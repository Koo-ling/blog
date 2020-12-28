package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.User;
import com.blog.service.ArticleService;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @RequestMapping("/backstage")
    public String backstage(){
        return "backstage";
    }
    @RequestMapping("/Index2")
    public String index2(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "Index2";
    }
    @RequestMapping("/index4/{userId}")
    public String index4(Model model,@PathVariable Long userId){
        User user = userService.findById(userId);
        model.addAttribute("user",user);
        return "index4";
    }
    @RequestMapping("/index3")
    public String index3(Model model){
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles",articles);
        return "index3";
    }
    @RequestMapping(value = "/save")
    public String save(User user){
        userService.save(user);
        return "redirect:/admin/Index2";
    }
    @RequestMapping(value = "/delete/{userId}")
    public String delete(@PathVariable("userId") Long userId){
        userService.delete(userId);
        return "redirect:/admin/Index2";
    }

    @RequestMapping(value = "/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/admin/Index2";
    }
    @RequestMapping(value = "/boke/delete/{articleId}")
    public String boke_delete(@PathVariable Long articleId){
        articleService.delete(articleId);
        return "redirect:/admin/index3";
    }
    @RequestMapping(value = "/boke/top/{articleId}")
    public String boke_top(@PathVariable Long articleId){
        Article article = articleService.findById(articleId);
        article.setReadNumber(article.getReadNumber()+10000);
        articleService.save(article);
        return "redirect:/admin/index3";
    }


}
