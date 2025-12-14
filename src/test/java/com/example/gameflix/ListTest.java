package com.example.gameflix;

import com.example.gameflix.service.ListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ListTest {
    @Autowired
    ListService listService;

    @Test
    void getAllLists_ShouldReturnList(){
        var lists = listService.getAllLists();
        Assertions.assertNotNull(lists);
    }

}
