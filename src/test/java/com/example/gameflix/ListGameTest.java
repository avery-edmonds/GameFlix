package com.example.gameflix;

import com.example.gameflix.service.ListGameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ListGameTest {
    @Autowired
    ListGameService listGameService;

    @Test
    void getListGamebyId_shouldreturnList(){
        var listGame = listGameService.getByListId(1);
        Assertions.assertNotNull(listGame);
    }
}
