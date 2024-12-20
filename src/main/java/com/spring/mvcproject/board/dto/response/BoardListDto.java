package com.spring.mvcproject.board.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.mvcproject.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BoardListDto {
    private Long bno; // 원본 게시물 번호
    private String shortTitle; // 5글자 이상 줄임 처리된 제목
    private String shortContent; // 15자 이상 줄임 처리된 글 내용

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime date; // 포맷팅된 날짜문자열 (2024/12/20)
    private int view; // 조회 수
    private boolean newArticle; // 새 게시물(1시간 이내)인가?

    public BoardListDto(Board b) {
        this.bno = b.getId();
        this.shortTitle = b.getTitle().length() > 5 ? b.getTitle().substring(0, 5) + "..." : b.getTitle();
        this.shortContent = b.getContent().length() > 15 ? b.getContent().substring(0, 15) + "..." : b.getContent();
//        this.date = b.getRegDateTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        this.date = b.getRegDateTime();
        this.view = b.getViewCount();
        //     12:00           <          10:30 + 1 => 11:30
        this.newArticle = LocalDateTime.now().isBefore(b.getRegDateTime().plusHours(1));
    }
}


    // 생성자
//    public BoardListDto(Board board) {
//        this.bno = board.getId();
//        this.shortTitle = shortTitle(board.getTitle());
//        this.shortContent = shortContent(board.getContent());
//        this.view = board.getViewCount();
//        this.date = formatDate(board.getRegDateTime());
//        this.newArticle = isNewArticle(board.getRegDateTime());
//    }
//
//    // 제목이 5자 이상이면 줄임 처리
//    private String shortTitle(String title) {
//        if (title.length() >= 5) {
//            return title.substring(0, 5) + "...";
//        }
//        return title;
//    }
//
//    // 내용이 15자 이상이면 줄임 처리
//    private String shortContent(String content) {
//        if (content.length() >= 15) {
//            return content.substring(0, 15) + "...";
//        }
//        return content;
//    }
//
//    // 날짜 포맷팅 (yyyy/MM/dd)
//    private String formatDate(LocalDateTime regDateTime) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        return regDateTime.format(formatter);
//    }
//
//    // 새 게시물 여부 (등록 시간이 현재 시간으로부터 1시간 이내인지 확인)
//    private boolean isNewArticle(LocalDateTime regDateTime) {
//        return regDateTime.isAfter(LocalDateTime.now().minusHours(1));
//    }
//}
