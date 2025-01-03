package com.spring.mvcproject.kpractice.api;

import com.spring.mvcproject.kpractice.practice.Practice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/practice")
public class PracticeApiController {
    public Map<Long, Practice> practiceStore = new HashMap<>();

    private Long nextId = 1L;

    public PracticeApiController() {
        Practice d1 = new Practice(nextId++, "김정학", 22);
        Practice d2 = new Practice(nextId++, "김민수", 15);
        Practice d3 = new Practice(nextId++, "김철수", 16);
        practiceStore.put(d1.getId(), d1);
        practiceStore.put(d2.getId(), d2);
        practiceStore.put(d3.getId(), d3);

    }
    // 회원 조회 API

    @GetMapping
    public List<Practice> getPractices() {
        return new ArrayList<>(practiceStore.values());
    }


}
