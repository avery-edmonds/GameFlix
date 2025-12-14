package com.example.gameflix;

import com.example.gameflix.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameTest {
    @Autowired
    private GameService gameService;

    @Test
    void getAllGames_ReturnsList(){
        var games = gameService.getAllGames();
        Assertions.assertNotNull(games);
    }
}
