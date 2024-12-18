package com.spring.mvcproject.board.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private Long id; // 글번호
    private String title; //제목
    private String content; //내용
    private int viewCount; //조회수
    private LocalDateTime regDateTime; //작성일시
}
