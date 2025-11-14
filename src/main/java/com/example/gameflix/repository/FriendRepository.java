
package com.example.gameflix.repository;



import com.example.gameflix.model.Friend;
import com.example.gameflix.model.FriendId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, FriendId> {
    List<Friend> findByUserId(Integer userId);
}
