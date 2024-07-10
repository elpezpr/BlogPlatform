package com.labs.BlogPlatform.controller.impl;

import com.labs.BlogPlatform.model.Article;
import com.labs.BlogPlatform.service.impl.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    // ********** GET **********

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // ********** POST **********

    @PostMapping("/articles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveArticle(@RequestBody @Valid Article article) {
        articleService.saveArticle(article);
    }

    // ********** DELETE **********

    @DeleteMapping("/article/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
