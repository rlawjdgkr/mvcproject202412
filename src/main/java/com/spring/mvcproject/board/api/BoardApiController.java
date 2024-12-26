package com.spring.mvcproject.board.api;

import com.spring.mvcproject.board.dto.request.BoardSaveDto;
import com.spring.mvcproject.board.dto.response.BoardDetailResponse;
import com.spring.mvcproject.board.dto.response.BoardListDto;
import com.spring.mvcproject.board.entity.Board;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardApiController {

    private Map<Long, Board> boardStore = new HashMap<>();

    private long nextId = 1;

    public BoardApiController() {
        Board b1 = Board.of(nextId++, "꿀잼게시물", "개노잼이야 사실");
        b1.setRegDateTime(LocalDateTime.of(2023, 11, 11, 0,0,0));
        Board b2 = Board.of(nextId++, "앙영하긔", "긔긔요미미미ㅣ");
        b2.setRegDateTime(LocalDateTime.of(2024, 3, 15, 0,0,0));
        Board b3 = Board.of(nextId++, "이마트 갈때...", "홈플러스 쿠폰써도 되나요");

        boardStore.put(b1.getId(), b1);
        boardStore.put(b2.getId(), b2);
        boardStore.put(b3.getId(), b3);
    }

    // 게시물 목록조회 GET
    @GetMapping
    public ResponseEntity<?> boardList() {
        // 게시물 목록은 최신글이 가장 위에 있어야 함
        List<BoardListDto> collect = new ArrayList<>(boardStore.values())
                .stream()
                .sorted(comparing(Board::getRegDateTime).reversed())
                .map(b -> new BoardListDto(b))
                .collect(toList());

        return ResponseEntity.ok().body(collect)
                ;
    }

    // 게시물 삭제 DELETE
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id) {
        Board removed = boardStore.remove(id);
        if (removed == null) {
            return "해당 id는 존재하지 않습니다: id = " + id;
        }
        return "게시물 삭제 성공! - " + removed;
    }

    // 게시물 등록 POST
    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestBody @Valid BoardSaveDto dto
            , BindingResult bindingResult
    ) {
        // 입력값 검증 응답 처리
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err -> {
                errorMap.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity
                    .badRequest()
                    .body(errorMap)
                    ;
        }

        System.out.println("dto = " + dto);

        Board board = dto.toEntity();
        board.setId(nextId++);

        System.out.println("board = " + board);
        boardStore.put(board.getId(), board);

        return ResponseEntity.ok().body("게시물 등록 성공! - "+ board);

    }

    // 게시물 상세조회 요청처리
    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        // 특정 게시물 찾아오기
        Board foundBoard = boardStore.get(id);

        // 게시물이 없을 경우
        if (foundBoard == null) {
            return ResponseEntity
                    .badRequest() // 400
                    .body(id + "번 게시물은 존재하지 않습니다.");
        }

        // 게시물 원본데이터를 클라이언트 스펙에 맞게 변환
        return ResponseEntity
                .ok()
                .body(BoardDetailResponse.from(foundBoard));
    }

}
