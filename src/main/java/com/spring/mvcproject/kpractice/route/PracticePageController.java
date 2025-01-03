package com.spring.mvcproject.kpractice.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PracticePageController {

    @GetMapping("/practice/page")
    public String practicePage() {
        // 해당 JSP파일의 경로를 적음

        return "practice/practice";
    }
}
