package com.spring.mvcproject.chap2_2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    //GET요청
//    @RequestMapping(value = "/chap2-2/hello" , method = RequestMethod.POST)
    @GetMapping("/chap2-2/hello")  //위 코드를 함축한 GET 코드
    @ResponseBody

    public String hello(){
        System.out.println("GET요청이 들어옴!!!");
        return "hello spring";

    }
    //JSP 응답
    @GetMapping("/chap2-2/getjsp")
    public String getJsp(){
        return "/WEB-INF/hello.jsp";
    }
}
