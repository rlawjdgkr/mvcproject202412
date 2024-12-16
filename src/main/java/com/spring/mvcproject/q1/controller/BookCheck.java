package com.spring.mvcproject.q1.controller;

import com.spring.mvcproject.q1.entity.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/book")
public class BookCheck {
    Map<Long, BookRepository> bookApi = new HashMap<>();
    private Long currentId = 1L;

    @RequestMapping("/{id}")
    public String getId(@PathVariable Long id) {
        BookRepository book = bookApi.get(id);
        if (book == null) {
            return "도서 ID" + id + "는 존재하지 않습니다.";
        }
        return "도서 정보" + id;
        }
    @PostMapping
    public String addBook(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam Long price) {
        BookRepository book = new BookRepository(currentId++, title, author, price);
        bookApi.put(book.getId(), book);
        return "생성된 정보" + book;


    }
    }

