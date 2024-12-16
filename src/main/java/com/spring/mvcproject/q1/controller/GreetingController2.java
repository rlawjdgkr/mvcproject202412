package com.spring.mvcproject.q1.controller;

import org.springframework.web.bind.annotation. GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class GreetingController2 {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring MVC!";
    }
}
