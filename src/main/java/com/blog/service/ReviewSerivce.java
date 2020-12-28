package com.blog.service;

import com.blog.model.Review;

import java.util.List;


public interface ReviewSerivce {
    void save(Review review);

    void delete(Long id);

    Review update(Review review);

    Review findById(Long id);

    List<Review> findAll();

    List<Review> findByUserId(Long id);

    List<Review> findByArticleId(Long id);

    List<Review> findByReviewId(Long id);
}
