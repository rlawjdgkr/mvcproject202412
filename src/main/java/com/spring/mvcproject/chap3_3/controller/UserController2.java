package com.spring.mvcproject.chap3_3.controller;

import com.spring.mvcproject.chap3_3.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v3-3/users")
public class UserController2 {
    private Map<Long, User> userStore = new HashMap<>();
    private long nextId = 1;

    // 사용자 생성
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){

        if(user.getAge() <0){
            HttpHeaders headers = new HttpHeaders();
            headers.add("cause","bad-age");
            headers.add("my-pet","cat");
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .headers(headers)
                    .body("나이는 양수여야 합니다. age - " + user.getAge());
        }
        if(user.getName().isBlank()){
            return ResponseEntity
//                    .status(HttpStatus.UNAUTHORIZED)
                    .badRequest()
                    .body("이름은 필수값입니다");
        }
        user.setId(nextId++);
        System.out.println("user = " + user);
        userStore.put(user.getId(), user);
        return ResponseEntity
//                .status(HttpStatus.OK)
                .ok()
                .body("유저 정보가 생성되었습니다.  -" + user);

    }
}
