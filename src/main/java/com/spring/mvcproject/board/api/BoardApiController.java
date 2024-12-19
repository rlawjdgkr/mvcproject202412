package com.spring.mvcproject.board.api;

import com.spring.mvcproject.board.dto.request.BoardSaveDto;
import com.spring.mvcproject.board.entity.Board;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardApiController {
    private Map<Long, Board> data = new HashMap<>();
    private Long nextId = 1L;

    public BoardApiController() {
        Board b1 = Board.of(nextId++, "꿀잼게시물" , "개노잼이야 사실");
        Board b2 = Board.of(nextId++, "노잼게시물" , "개꿀잼이야 사실");
        Board b3 = Board.of(nextId++, "방구뽕" , "방구");

        data.put(b1.getId(), b1);
        data.put(b2.getId(), b2);
        data.put(b3.getId(), b3);

    }


    // 게시물 목록조회 GET
    @GetMapping
    public List<Board> getBoards() {
        return new ArrayList<>(data.values())
                .stream()
                .sorted(Comparator.comparing(Board::getId).reversed())
                .collect(Collectors.toList());

    }
    //게시물 삭제 DELETE
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id) {
        data.remove(id);
        return "삭제되었습니다 id :" +id;
    }
    //게시물 등록 POST
    @PostMapping
    public ResponseEntity<?> createBoard(
            @RequestBody @Valid BoardSaveDto dto
        , BindingResult bindingResult
     ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseEntity
                    .badRequest()
                    .body(errors);
        }
        Board board = new Board(dto);
        board.setId(nextId++);

        data.put(board.getId(), board);
        return ResponseEntity
                .ok()
                .body("게시판 생성 완료!" + board.toString());
    }
}
