package com.spring.mvcproject.database.jdbc.repository;

import com.spring.mvcproject.database.jdbc.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;
    @Test
    void saveTest(){
        Person p = new Person(2L,"김갑돌",40);

        personRepository.save(p);
    }
    @Test
    void updateTest(){
        Person p = new Person(2L,"티니핑",5);
        personRepository.save(p);
    }
}