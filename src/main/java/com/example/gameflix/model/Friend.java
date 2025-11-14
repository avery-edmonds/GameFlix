package com.example.gameflix.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@IdClass(FriendId.class)
public class Friend {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Id
    @Column(name = "friend_id")
    private int friendId;

    @Column(name = "friends_since")
    private Date friendsSince;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private User user;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public Date getFriendsSince() {
        return friendsSince;
    }

    public void setFriendsSince(Date friendsSince) {
        this.friendsSince = friendsSince;
    }
}
