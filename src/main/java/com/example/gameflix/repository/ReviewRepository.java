package com.example.gameflix.repository;


import com.example.gameflix.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByUser_Id(Integer userId);
    List<Review> findByGameGameId(Integer gameId);
}
