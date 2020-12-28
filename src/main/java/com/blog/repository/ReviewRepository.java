package com.blog.repository;

import com.blog.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;



public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findById(Long id);

    @Query("select r from  Review   r where user_id = ?1")
    List<Review> findByUserId(Long id);

    @Query("select r from  Review   r where article_id = ?1")
    List<Review> findByArticleId(Long id);

    @Query("select r from  Review   r where review_id = ?1")
    List<Review> findByReviewId(Long id);


}
