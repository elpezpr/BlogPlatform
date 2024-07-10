package com.labs.BlogPlatform.controller.impl;

import com.labs.BlogPlatform.controller.dto.PostContentDTO;
import com.labs.BlogPlatform.controller.dto.PostTitleDTO;
import com.labs.BlogPlatform.model.Post;
import com.labs.BlogPlatform.service.impl.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService postService;

    // ********** GET **********

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id) {
        return  postService.getPostById(id);
    }

    @GetMapping("/post/title")
    public Post getPostByTitle(@RequestParam @Valid String title) {
        return postService.getPostByTitle(title);
    }

    @GetMapping("/posts/content")
    public List<Post> getPostByContentContaining(@RequestParam String keyword) {
        return postService.getPostByContentContaining(keyword);
    }

    // ********** POST **********

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public void  savePost(@RequestBody @Valid Post post) {
        postService.savePost(post);
    }

    // ********** PUT **********

    @PutMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@RequestBody @Valid Post post, @PathVariable Long id) {
        postService.updatePost(post, id);
    }

    // ********** PATCH **********

    @PatchMapping("/posts/title/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePostTitle(@RequestBody @Valid PostTitleDTO postTitleDTO, @PathVariable Long id) {
        postService.updatePostTitle(postTitleDTO.getTitle(), id);
    }

    @PatchMapping("/posts/content/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePostContent(@RequestBody @Valid PostContentDTO postContentDTO, @PathVariable Long id) {
        postService.updatePostContent(postContentDTO.getContent(), id);
    }

    // ********** DELETE **********

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
