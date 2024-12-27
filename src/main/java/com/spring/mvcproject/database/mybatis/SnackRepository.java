package com.spring.mvcproject.database.mybatis;

import com.spring.mvcproject.database.mybatis.entity.Pet;
import com.spring.mvcproject.database.mybatis.entity.Snack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SnackRepository {
    //CRUD

    // CREATE
     boolean save(Snack snack);

     //READ (snack을 리스트로 받아온다.)
    List<Snack> findAll();

    //단일 READ
    Pet findById(Long id);

    // UPDATE

    boolean update(String name);

    //DELETE
    boolean delete(Long id);

}
