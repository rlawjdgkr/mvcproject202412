package com.spring.mvcproject.score.routes;

import com.spring.mvcproject.score.entity.Score;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// 성적관리에 필요한 JSP파일들을 포워딩하는 컨트롤러
@Controller
public class ScorePageController {
//
//    @GetMapping("/score/page")
//    public String scorePage(Model model) {
//        //model 은 페이지를 띄울때 데이터를 던지는 것
//        model.addAttribute("title", "성적 관리");
//        model.addAttribute("foods", List.of("짜장","떡볶이","오렌지"));
//        // 해당 JSP파일의 경로를 적음
//        return "score/score-page";
//
//    }

    @GetMapping("/score/page")
    public ModelAndView scorePage() {
        //model 은 페이지를 띄울때 데이터를 던지는 것
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "성적 관리");
        mv.addObject("foods", List.of("짜장","떡볶이","오렌지"));
        // 해당 JSP파일의 경로를 적음
        mv.setViewName("score/score-page");
        return mv;

    }
}