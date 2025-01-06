package com.spring.mvcproject.kpractice.api;

import com.spring.mvcproject.kpractice.dto.PracticeDto;
import com.spring.mvcproject.kpractice.practice.Practice;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody @Valid PracticeDto dto,
            BindingResult bindingResult) {

        // 입력값 검증
        if (bindingResult.hasErrors()) {
            // 에러 메시지를 생성하여 반환
            String errorMessage = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .reduce("", (a, b) -> a + "\n" + b);
            return ResponseEntity.badRequest().body(errorMessage);
        }

        // DTO → 엔티티 변환
        Practice practice = dto.toEntity();
        practice.setId(nextId++);
        practiceStore.put(practice.getId(), practice);

        return ResponseEntity.ok().body("생성 완료");
    }


}
