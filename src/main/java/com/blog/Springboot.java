package com.blog;

import com.blog.model.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@SpringBootApplication
public class Springboot {
    @Autowired
    ArticleService articleService;
    @RequestMapping(value = {"/","/index"})
    public String  getArticles(Model model){

        List<Article> articles = articleService.findByReadNumber();
        model.addAttribute("articles",articles);
        return "index";
    }
    public static void main(String[] args)  {
        SpringApplication.run(Springboot.class, args);
    }
}
