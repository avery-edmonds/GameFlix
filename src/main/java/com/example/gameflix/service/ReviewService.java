package com.example.gameflix.service;

import com.example.gameflix.model.Review;
import com.example.gameflix.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Integer id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByUser(Integer userId) {
        return reviewRepository.findByUser_Id(userId);
    }

    public List<Review> getReviewsByGame(Integer gameId) {
        return reviewRepository.findByGameGameId(gameId);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }
}
