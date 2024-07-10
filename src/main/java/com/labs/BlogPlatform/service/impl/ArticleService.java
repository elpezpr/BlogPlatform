package com.labs.BlogPlatform.service.impl;

import com.labs.BlogPlatform.model.Article;
import com.labs.BlogPlatform.repository.ArticleRepository;
import com.labs.BlogPlatform.service.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        if (articles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No articles found");
        }
        return  articles;
    }

    @Override
    public void saveArticle(Article article) {
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post must not be null");
        }
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
    }
}
