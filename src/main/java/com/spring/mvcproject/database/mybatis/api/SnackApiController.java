package com.spring.mvcproject.database.mybatis.api;

import com.spring.mvcproject.database.mybatis.SnackRepository;
import com.spring.mvcproject.database.mybatis.entity.Snack;
import com.spring.mvcproject.database.mybatis.service.SnackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snacks")
@RequiredArgsConstructor

public class SnackApiController {
    private final SnackService snackService;
    private final SnackRepository snackRepository;

    //목록 조회
    @GetMapping
    public ResponseEntity<?> finaAllSnacks(@RequestBody Snack snack) {
        List<Snack> pet = snackService.getSnacks();
        return ResponseEntity.ok().body(pet);

    }
    //목록 생성
    @PostMapping
    public ResponseEntity<?> addSnack(@RequestBody Snack snack){
        boolean snack1 = snackService.createSnack(snack);
        return ResponseEntity.ok().body(snack1);
    }


}
