package com.blog.service.Impl;

import com.blog.model.Review;
import com.blog.repository.ReviewRepository;
import com.blog.service.ReviewSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewSerivceImpl implements ReviewSerivce {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public void save(Review review) {
        reviewRepository.save(review);

    }

    @Override
    public void delete(Long id) {
        reviewRepository.delete(id);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.saveAndFlush(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findByUserId(Long id) {
        return reviewRepository.findByUserId(id);
    }

    @Override
    public List<Review> findByArticleId(Long id) {
        return reviewRepository.findByArticleId(id);
    }

    @Override
    public List<Review> findByReviewId(Long id) {
        return reviewRepository.findByReviewId(id);
    }
}
