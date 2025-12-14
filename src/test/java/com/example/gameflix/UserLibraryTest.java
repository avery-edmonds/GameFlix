package com.example.gameflix;

import com.example.gameflix.model.UserLibrary;
import com.example.gameflix.service.UserLibraryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserLibraryTest {
    @Autowired
    private UserLibraryService userLibraryService;

    @Test
    void getLibariesByUser_ShouldReturnList() {
        var list = userLibraryService.getLibrariesByUser(1);
        Assertions.assertNotNull(list);
    }
}
