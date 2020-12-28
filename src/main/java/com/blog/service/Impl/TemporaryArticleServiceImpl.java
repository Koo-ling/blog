package com.blog.service.Impl;

import com.blog.model.TemporaryArticle;
import com.blog.repository.TemporaryArticleRepository;
import com.blog.service.TemporaryArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TemporaryArticleServiceImpl implements TemporaryArticleService {
    @Autowired
    private TemporaryArticleRepository temporaryArticleRepository;
    @Override
    public void save(TemporaryArticle article) {
        temporaryArticleRepository.save(article);
    }

    @Override
    public void delete(Long id) {
         temporaryArticleRepository.delete(id);
    }

    @Override
    public void update(TemporaryArticle article) {
       temporaryArticleRepository.saveAndFlush(article);
    }

    @Override
    public TemporaryArticle findById(Long id) {
        return temporaryArticleRepository.findById(id);
    }

    @Override
    public List<TemporaryArticle> findAll() {
        return temporaryArticleRepository.findAll();
    }

    @Override
    public List<TemporaryArticle> findByUserId(Long id) {
        return temporaryArticleRepository.findByUserId(id);
    }

}
