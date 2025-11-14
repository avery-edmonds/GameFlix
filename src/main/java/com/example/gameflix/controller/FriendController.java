package com.example.gameflix.controller;

import com.example.gameflix.model.Friend;
import com.example.gameflix.model.FriendId;
import com.example.gameflix.service.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/{userId}")
    public List<Friend> getFriends(@PathVariable Integer userId) {
        return friendService.getFriendsByUser(userId);
    }

    @PostMapping
    public Friend addFriend(@RequestBody Friend friend) {
        return friendService.addFriend(friend);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeFriend(@RequestBody FriendId id) {
        friendService.removeFriend(id);
        return ResponseEntity.noContent().build();
    }
}
