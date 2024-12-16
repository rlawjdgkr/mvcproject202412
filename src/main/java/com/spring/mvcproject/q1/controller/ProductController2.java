package com.spring.mvcproject.q1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")

public class ProductController2 {
    @GetMapping("/product/{id}")
        public String getProduct(@PathVariable String id) {
        return "Product ID: " + id;
    }
}
