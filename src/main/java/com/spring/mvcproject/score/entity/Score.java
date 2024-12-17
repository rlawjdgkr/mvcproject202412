package com.spring.mvcproject.score.entity;

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

}
