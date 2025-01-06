package com.spring.mvcproject.kpractice.dto;

import com.spring.mvcproject.kpractice.practice.Practice;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PracticeDto {

    private Long id;
    @NotBlank(message = "이름은 필수값입니다.")
    private String name;
    @Max(value = 200, message = "200살 미만으로 작성해주세요")
    private int age;


public Practice toEntity(){
    Practice practice = new Practice();
    practice.setId(this.id);
    practice.setName(this.name);
    practice.setAge(this.age);
    return practice;
}

}
