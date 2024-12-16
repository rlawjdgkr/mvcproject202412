package com.spring.mvcproject.chap1_3;

// Controller: 클라이언트의 요청을 받아 로직을 수행하는 역할

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller   //DispatcherServlet이 이 객체를 탐색해서 연결해줌
@RequestMapping("/chap01")  //클래스레벨에서도 매핑을 할 수 있다.
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody //JSON응답
    public String hello(){
        System.out.println("hello~~ spring mvc  world!");
            return "메롱메롱 안녕안녕";
    }
    @RequestMapping("/bye")
    public String bye(){
        System.out.println("bye~~ spring mvc  world!");
        return "";
    }
}
