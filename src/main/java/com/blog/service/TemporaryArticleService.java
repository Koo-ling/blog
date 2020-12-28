package com.blog.service;


import com.blog.model.TemporaryArticle;

import java.util.List;


public interface TemporaryArticleService {
    void save(TemporaryArticle article);
    void delete(Long id);
    void update(TemporaryArticle article);
    TemporaryArticle findById(Long id);
    List<TemporaryArticle> findAll();
    List<TemporaryArticle> findByUserId(Long id);
}
