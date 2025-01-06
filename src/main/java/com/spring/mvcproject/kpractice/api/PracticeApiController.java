package com.spring.mvcproject.kpractice.api;

import com.spring.mvcproject.kpractice.practice.Practice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   // 개별 조회 API
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        Practice practice = practiceStore.get(id);
        if (practice == null) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok().body(practice);
    }

    // 삭제 API
    @DeleteMapping("/{id}")
    public ResponseEntity<?> Delete(@PathVariable Long id){
        practiceStore.remove(id);
        return ResponseEntity.ok().body("삭제가 완료되었습니다");

    }

    //추가 API
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Practice practice){
        practice.setId(nextId++);
        practiceStore.put(practice.getId(), practice);
    return ResponseEntity.ok().body("생성완료");
  }


}
