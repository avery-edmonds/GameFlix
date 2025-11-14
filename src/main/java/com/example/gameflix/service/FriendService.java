package com.example.gameflix.service;

import com.example.gameflix.model.Friend;
import com.example.gameflix.model.FriendId;
import com.example.gameflix.repository.FriendRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<Friend> getFriendsByUser(Integer userId) {
        return friendRepository.findByUserId(userId);
    }

    public Friend addFriend(Friend friend) {
        return friendRepository.save(friend);
    }

    public void removeFriend(FriendId id) {
        friendRepository.deleteById(id);
    }
}
