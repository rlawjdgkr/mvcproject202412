package com.spring.mvcproject.database.mybatis;

import com.spring.mvcproject.database.mybatis.entity.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetRepositoryTest {

    @Autowired
    PetRepository petRepository;
    @Autowired
    private InternalResourceViewResolver internalResourceViewResolver;

    @Test
    void saveTest(){
        Pet pet = Pet.builder()
                .petName("날라버러")
                .petAge(20)
                .injection(true)
                .build();
        petRepository.save(pet);
    }
    @Test
    void findByIdTest(){
        Pet fountPet = petRepository.findById(3L);
        System.out.println("fountPet = " + fountPet);
    }
    @Test
    void findAllTest(){
        List<Pet> petList = petRepository.findAll();

        System.out.println("\n\n================");
        petList.forEach(System.out::println);
    }
    @Test
    void deleteByIdTest(){
       petRepository.deletePet(3L);

    }
    @Test
    void countTest(){
        int count = petRepository.petCount();
        System.out.println("count = " + count);
    }
}