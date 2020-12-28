package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.Review;
import com.blog.model.User;
import com.blog.service.ArticleService;
import com.blog.service.ReviewSerivce;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ReviewSerivce reviewSerivce;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/saveReview/{articleId}",method = RequestMethod.POST)
    public String   saveReview(Review review, @PathVariable Long articleId){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Article article = articleService.findById(articleId);
        review.setArticle(article);
        review.setUser(user);
        reviewSerivce.save(review);
        return "redirect:/index";
    }
}
