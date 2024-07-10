package com.labs.BlogPlatform.service.interfaces;

import com.labs.BlogPlatform.model.Article;

import java.util.List;

public interface IArticleService {

    List<Article> getAllArticles();

    void saveArticle(Article article);

    void deleteArticle(Long id);
}
