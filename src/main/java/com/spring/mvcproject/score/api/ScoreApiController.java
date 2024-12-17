package com.spring.mvcproject.score.api;

import com.spring.mvcproject.score.entity.Score;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoreApiController {

    private Map<Long, Score> scoreStore = new HashMap<>();

    private Long nextId = 1L;

    public ScoreApiController() {
        Score s1 = new Score(nextId++, "김말복", 100, 88, 75);
        Score s2 = new Score(nextId++, "김수포", 55, 95, 15);
        Score s3 = new Score(nextId++, "김마이클", 4, 100, 40);
        Score s4 = new Score(nextId++, "김강림", 4, 100, 40);
        Score s5 = new Score(nextId++, "김걍림", 2, 50, 40);
        Score s6 = new Score(nextId++, "김각림", 100, 100, 40);

        scoreStore.put(s1.getId(), s1);
        scoreStore.put(s2.getId(), s2);
        scoreStore.put(s3.getId(), s3);
        scoreStore.put(s4.getId(), s4);
        scoreStore.put(s5.getId(), s5);
        scoreStore.put(s6.getId(), s6);

    }
    // 전체 성적정보 조회
    @GetMapping
    public List<Score> scoreList(@RequestParam(defaultValue = "id") String sort) {
        return scoreStore.values().stream()
                .sorted(getComparator(sort))
                .collect(Collectors.toList());
    }

    private Comparator<Score> getComparator(String sort) {
        switch (sort) {
            case "name":
                return Comparator.comparing(Score::getName);
            case "average":
                return Comparator.comparingDouble(score ->
                        (score.getKor() + score.getEng() + score.getMath()) / 3.0
                );
            default: // id 기준 정렬
                return Comparator.comparingLong(Score::getId);
        }
    }


}
