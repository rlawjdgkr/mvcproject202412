package com.spring.mvcproject.database.mybatis.service;

import com.spring.mvcproject.database.mybatis.SnackRepository;
import com.spring.mvcproject.database.mybatis.entity.Snack;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SnackService {

        private final SnackRepository snackRepository;
    //조회
    public List<Snack> getSnacks() {
        return snackRepository.findAll();

    }
    // 생성
    public boolean createSnack(Snack snack) {
        boolean result = snackRepository.save(snack);
        return result;
    }
    //수정
    public boolean updateSnack(Snack snack) {
        boolean result = snackRepository.save(snack);
        return result;
    }
    //삭제 중간처리
    public boolean deleteSnack(Long id){
        boolean delete = snackRepository.delete(id);
        return delete;
    }


}
