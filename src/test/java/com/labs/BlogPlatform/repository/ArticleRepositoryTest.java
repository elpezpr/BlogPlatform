package com.labs.BlogPlatform.repository;

import com.labs.BlogPlatform.model.Article;
import com.labs.BlogPlatform.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PostRepository postRepository;

    Post post;
    Article article;

    @BeforeEach
    void  setUp() {
        post = new Post("Mi Primer Post", "El contenido de este post");
        post = postRepository.save(post);

        article = new Article("Un Gran Articulo","El contenido aqui", "Deportes");
        article = articleRepository.save(article);
    }

    @AfterEach
    void tearDown() {
        articleRepository.deleteAll();
        postRepository.deleteAll();
    }

    @Test
    void testSaveArticle() {
        Article newArticle = new Article("Un Articulo Diferente", "Contenido nuevo aqui", "Tecnologia");

        articleRepository.save(newArticle);

        Article savedArticle = articleRepository.findById(newArticle.getId()).get();

        assertEquals("Un Articulo Diferente", savedArticle.getTitle());
        assertEquals("Contenido nuevo aqui", savedArticle.getContent());
        assertEquals("Tecnologia", savedArticle.getTopic());
    }

    @Test
    void findByTopic() {
        List<Article> articles = articleRepository.findByTopic("Deportes");
        assertFalse(articles.isEmpty());
        assertEquals("Deportes", articles.get(0).getTopic());
    }

    @Test
    void testUpdateArticle() {
        article.setTitle("Titulo Cambiado");
        article.setContent("Contenido Cambiado");
        article.setTopic("Paisajes");

        articleRepository.save(article);

        Article updatedArticle = articleRepository.findById(article.getId()).get();

        assertEquals("Titulo Cambiado", updatedArticle.getTitle());
        assertEquals("Contenido Cambiado", updatedArticle.getContent());
        assertEquals("Paisajes", updatedArticle.getTopic());
    }

    @Test
    void  findAllByTopicContaining() {
        List<Article> articleList = articleRepository.findAllByTopicContaining("Deportes");
        assertFalse(articleList.isEmpty());
        for (Article article : articleList) {
            assertTrue(article.getTopic().contains("Deportes"));
        }

    }
}