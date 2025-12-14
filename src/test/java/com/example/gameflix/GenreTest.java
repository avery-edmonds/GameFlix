package com.example.gameflix;

import com.example.gameflix.service.GenreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GenreTest {
    @Autowired
    private GenreService genreService;

    @Test
    void getAllGenres_ShouldReturnList() {
        var genre = genreService.getAllGenres();
        Assertions.assertNotNull(genre);
    }

}
