package com.example.gameflix.controller;

import com.example.gameflix.model.Friend;
import com.example.gameflix.model.FriendId;
import com.example.gameflix.model.User;
import com.example.gameflix.service.FriendService;
import com.example.gameflix.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friends")
@CrossOrigin(origins = "*")
public class FriendController {

    private final FriendService friendService;
    private final UserService userService;

    public FriendController(FriendService friendService,  UserService userService) {
        this.friendService = friendService;
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public List<Friend> getFriends(@PathVariable Integer userId) {
        return friendService.getFriendsByUser(userId);
    }

    @PostMapping
    public Friend addFriend(@RequestBody Friend friend) {
        return friendService.addFriend(friend);
    }

    @DeleteMapping("/{userId}/{friendId}")
    public ResponseEntity<Void> removeFriend(
            @PathVariable Integer userId,
            @PathVariable Integer friendId
    ) {
        friendService.removeFriend(new FriendId(userId, friendId));
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String username) {
        return userService.searchByUsername(username);
    }
}
