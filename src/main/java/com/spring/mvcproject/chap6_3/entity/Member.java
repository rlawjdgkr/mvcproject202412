package com.spring.mvcproject.chap6_3.entity;

import lombok.*;

@Getter@Setter@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member {

    private String account;
    private String password;
    private String nickname;
}
