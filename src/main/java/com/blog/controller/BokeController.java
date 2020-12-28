package com.blog.controller;

import com.blog.model.*;
import com.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



@Controller
@RequestMapping("/boke")
public class BokeController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ReviewSerivce reviewSerivce;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value ="/getArticles")
    public String  getArticles(Model model, Long id){

        List<Article> articles = articleService.findByTypeId(id);
        model.addAttribute("articles",articles);
        return "index";
    }
    @RequestMapping(value ="/getArticle/{id}")
    public String  getArticle(Model model,@PathVariable("id") Long id){

        Article article = articleService.findById(id);
        List<Review> reviews = reviewSerivce.findByArticleId(article.getId());
        model.addAttribute("article",article);
        model.addAttribute("reviews",reviews);
        return "boke";
    }
    @RequestMapping(value ="/search")
    public String  search(Article article,Model model){
           List<Article> articles = articleService.findByTitle(article.getTitle());
          model.addAttribute("articles",articles);
        return "index";
    }
    /**
     * 保存文章
     */
    @RequestMapping("/saveArticle")
    public String  saveArticle(Article article){
        User user = (User) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        Category category = categoryService.findById(article.getCategoryId()) ;

        article.setUser(user);
        article.setCategory(category);

        articleService.save(article);
        return "redirect:/index";
    }
}
