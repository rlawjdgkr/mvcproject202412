package com.spring.mvcproject.board.dto.response;

import com.spring.mvcproject.board.entity.Board;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BoardListDtoTest {
    @Test
    void test() {
        //원본 게시물
        new Board(1L,"하하호호 재밌따","1234356765432345643",23, LocalDateTime.of(2020,1,1,12,12));

    }
}