package com.labs.BlogPlatform.util;

import com.labs.BlogPlatform.repository.ArticleRepository;
import com.labs.BlogPlatform.repository.CommentRepository;
import com.labs.BlogPlatform.repository.PostRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Clear the database after app stops running
@Component
public class DataCleaner {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    @PreDestroy
    public void cleanUp() {
        commentRepository.deleteAll();
        articleRepository.deleteAll();
        postRepository.deleteAll();
    }
}
