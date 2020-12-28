package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.User;
import com.blog.service.ArticleService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/save")
    public String single(User user){
         userService.save(user);
        return "redirect:/";
    }
    @RequestMapping(value ="/myboke")
    public String  getArticles(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Article> articles = articleService.findByUserId(user.getId());
        model.addAttribute("articles",articles);
        return "index";
    }
}
