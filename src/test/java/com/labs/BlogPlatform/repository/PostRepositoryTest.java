package com.labs.BlogPlatform.repository;

import com.labs.BlogPlatform.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    Post post;

    @BeforeEach
    void setUp() {
        post = new Post("Mi Primer Post", "El contenido de este post");
        post = postRepository.save(post);
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }
    // Check if each property is present
    @Test
    void testCreatePost() {
        assertNotNull(post.getId());
        assertEquals("Mi Primer Post", post.getTitle());
        assertEquals("El contenido de este post", post.getContent());
    }

    @Test
    void findByTitle() {
        Optional<Post> optionalPost = postRepository.findByTitle("Mi Primer Post");

        assertTrue(optionalPost.isPresent());
        Post foundPost = optionalPost.get();

        assertEquals("Mi Primer Post", foundPost.getTitle());
        assertEquals("El contenido de este post", foundPost.getContent());
    }

    @Test
    void testUpdatePostTitle() {
        post.setTitle("Titulo Cambiado");
        Post updatedPost = postRepository.save(post);

        Optional<Post> updatedTitlePostOptional = postRepository.findById(updatedPost.getId());

        assertTrue(updatedTitlePostOptional.isPresent());
        Post updatedTitlePost = updatedTitlePostOptional.get();
        assertEquals("Titulo Cambiado", updatedTitlePost.getTitle());
    }


}