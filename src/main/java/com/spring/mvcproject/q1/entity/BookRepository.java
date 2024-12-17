package com.spring.mvcproject.q1.entity;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BookRepository {
    private Long id;
    private String title;
    private String author;
    private int price;



}
