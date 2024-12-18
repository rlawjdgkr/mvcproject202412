package com.spring.mvcproject.board.api;

import com.spring.mvcproject.board.entity.Board;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/boards")
public class BoardApiController {
    private Map<Long, Board> data = new HashMap<>();
    private Long nextId = 1L;

    public BoardApiController() {
        Board bd1 = new Board(nextId, "김철수", "하하호호", 3, LocalDateTime.now());
        nextId++;
        Board bd2 = new Board(nextId, "박지훈", "가갸거겨", 20, LocalDateTime.now());
        nextId++;
        Board bd3 = new Board(nextId, "최정", "최정랜더스", 30, LocalDateTime.now());
        nextId++;
        data.put(bd1.getId(), bd1);
        data.put(bd2.getId(), bd2);
        data.put(bd3.getId(), bd3);

    }


    // 게시물 목록조회 GET
    @GetMapping
    public List<Board> getBoards() {
        return data.values()
                .stream()
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
    public String createBoard(@RequestBody Board board) {
        data.put(board.getId(), board);
        return "생성되었습니다" + board.getId();
    }
}
