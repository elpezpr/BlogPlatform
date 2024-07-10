package com.labs.BlogPlatform.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.BlogPlatform.model.Post;
import com.labs.BlogPlatform.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostControllerTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Post post;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        post = new Post("Titulo","Contenido");

        post = postRepository.save(post);
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @Test
    void getAllPosts_validRequest_allPosts() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/posts"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(post.getTitle()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(post.getContent()));
    }

    @Test
    void getPostById_validId_correctPost() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/post/{id}", post.getId()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains(post.getTitle()));
        assertTrue(mvcResult.getResponse().getContentAsString().contains(post.getContent()));
    }

    @Test
    void getPostById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/post/123").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}