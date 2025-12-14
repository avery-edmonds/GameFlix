package com.example.gameflix;

import com.example.gameflix.service.ReviewService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewTest {

    @Autowired
    ReviewService reviewService;

    @Test
    void getAllReviews_shouldreturnList(){
        var lists = reviewService.getAllReviews();
        Assertions.assertNotNull(lists);
    }
}
