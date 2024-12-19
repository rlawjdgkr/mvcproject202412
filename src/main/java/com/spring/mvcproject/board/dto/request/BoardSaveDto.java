package com.spring.mvcproject.board.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter@Getter@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BoardSaveDto {

    // 필수값 검증
    @NotBlank(message = "제목은 필수값입니다.")
    private String dtoTitle;

    @NotBlank(message = "내용은 필수입니다.")
    private String dtoContent;




}
