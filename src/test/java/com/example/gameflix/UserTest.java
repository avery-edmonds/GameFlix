package com.example.gameflix;

import com.example.gameflix.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    void getAllUsers(){
        var list = userService.getAllUsers();
        Assertions.assertNotNull(list);
    }
}
