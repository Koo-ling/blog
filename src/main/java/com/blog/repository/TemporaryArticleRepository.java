package com.blog.repository;


import com.blog.model.TemporaryArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;




public interface TemporaryArticleRepository  extends JpaRepository<TemporaryArticle,Long>{
    TemporaryArticle findById(Long id);
    @Query("select t from  TemporaryArticle t  where user_Id= ?1")
    List<TemporaryArticle> findByUserId(Long id);
}
