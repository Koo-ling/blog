package com.blog.repository;

import com.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;



public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findById(Long id);

    @Query("select a from  Article a where a.title like  concat('%',:title,'%') ")
    List<Article> findByTitleLike(@Param("title") String title);

    @Query("select a from  Article a order by a.readNumber  desc")
    List<Article> findByReadNumber();



    @Query("select a from  Article  a where user_Id = ?1")
    List<Article> findByUserId(Long id);

    @Query("select a from  Article  a where type_Id = ?1")
    List<Article> findByTypeId(Long id);

}
