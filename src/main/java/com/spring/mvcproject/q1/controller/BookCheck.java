package com.spring.mvcproject.q1.controller;

import com.spring.mvcproject.q1.entity.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/book")
public class BookCheck {

   private Map<Long, BookRepository> bookApi = new HashMap<>();
    private long nextId = 1;

    public BookCheck() {
        bookApi.put(nextId,new BookRepository(nextId,"키위","키위맨", 9000));
        nextId++;
        bookApi.put(nextId,new BookRepository(nextId,"레몬","레몬맨", 12043));
        nextId++;
        bookApi.put(nextId,new BookRepository(nextId,"망고","망고맨", 20123));
        nextId++;
    }
    //전체 상품 조회
    @GetMapping
    public List<BookRepository> list() {

        return bookApi.values()
                .stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookRepository getBook(@PathVariable long id) {
        BookRepository book = bookApi.get(id);
        return book;
    }
    @PostMapping
    public String create(@RequestParam String title,
                          @RequestParam String author,
                          @RequestParam int price
    ){
        //상품객체를 생성해서 맵에 저장
        BookRepository addBook = new BookRepository(nextId, title, author, price);

        bookApi.put(nextId++, addBook);
        return "상품이 생성되었습니다" + addBook;
    }
    @PutMapping("/{id}")
    public String update(@PathVariable long id,
                         @RequestParam String title,
                         @RequestParam int price){
        BookRepository book = bookApi.get(id);
        book.setTitle(title);
        book.setPrice(price);
        return "수정이 완료되었습니다";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        bookApi.remove(id);
        return id + "번 제거완료" ;
    }
    }

