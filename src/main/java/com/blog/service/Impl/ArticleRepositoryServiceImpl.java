package com.blog.service.Impl;

import com.blog.model.Article;
import com.blog.repository.ArticleRepository;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleRepositoryServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;


    /**
     * 保存
     * @param article
     */
    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id) {
          articleRepository.delete(id);
    }

    /**
     * 更新
     * @param article
     */
    @Override
    public void update(Article article) {
        articleRepository.saveAndFlush(article);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 通过文章标题模糊查找
     * @param title
     * @return
     */
    @Override
    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitleLike(title);
    }

    /**
     * 根据Id查找
     * @param id
     * @return
     */
    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id);
    }

    /**
     * 根据阅读量查找
     * @return
     */
    @Override
    public List<Article> findByReadNumber() {
        return articleRepository.findByReadNumber();
    }



    @Override
    public List<Article> findByUserId(Long id) {
        return articleRepository.findByUserId(id);
    }

    @Override
    public List<Article> findByTypeId(Long id) {
        return articleRepository.findByTypeId(id);
    }
}
