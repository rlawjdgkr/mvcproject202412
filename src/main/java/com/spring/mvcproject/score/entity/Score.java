package com.spring.mvcproject.score.entity;

import com.spring.mvcproject.score.dto.request.ScoreCreateDto;
import lombok.*;
import org.springframework.web.bind.annotation.ResponseBody;

// 학생 한명의 성적정보를 저장
@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Score {

    private Long id;
    private String name;
    private int kor, eng, math; //국영수 점수

    public Score(ScoreCreateDto dto) {
        this.name = dto.getStudentName();
        this.kor = dto.getKorean();
        this.eng = dto.getEnglish();
        this.math = dto.getMath();

    }
}
