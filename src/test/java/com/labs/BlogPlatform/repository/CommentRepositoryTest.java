package com.labs.BlogPlatform.repository;

import com.labs.BlogPlatform.model.Comment;
import com.labs.BlogPlatform.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    Comment comment;
    Post post;

    @BeforeEach
    void setUp() {
        post = new Post("Mi Primer Post", "El contenido de este post");
        post = postRepository.save(post);

        comment = new Comment("Mi comentario aqui", post);
        comment = commentRepository.save(comment);
    }

    @AfterEach
    void tearDOwn() {
        commentRepository.deleteAll();
        postRepository.deleteAll();
    }

    @Test
    void testFindById() {
        Optional<Comment> foundComment = commentRepository.findById(comment.getId());
        assertTrue(foundComment.isPresent());
    }

    @Test
    void testFindByPostId() {
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        assertEquals(1, comments.size());
        assertEquals(comment.getId(), comments.get(0).getId());
    }
}