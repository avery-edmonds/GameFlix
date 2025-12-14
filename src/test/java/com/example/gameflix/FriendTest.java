package com.example.gameflix;

import com.example.gameflix.service.FriendService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FriendTest {

    @Autowired
    FriendService friendService;

    @Test
    void getFriendsByUser_ShouldReturnId(){
        var userFriends = friendService.getFriendsByUser(1);
        Assertions.assertNotNull(userFriends);
    }
}
