package com.labs.BlogPlatform.service.impl;

import com.labs.BlogPlatform.model.Post;
import com.labs.BlogPlatform.repository.PostRepository;
import com.labs.BlogPlatform.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No posts found");
        }
        return posts;

    }
    @Override
    public Post getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No post found with id: " + id);
        }
    }

    @Override
    public Post getPostByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title can't be empty");
        }
        Optional<Post> optionalPost = postRepository.findByTitle(title);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with the title: " + title);
        }
    }

    @Override
    public List<Post> getPostByContentContaining(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Keyword can't be empty");
        }
        List<Post> posts = postRepository.findByContentContaining(keyword);

        if (!posts.isEmpty()) {
            return posts;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No posts found containing the keyword: " + keyword);
        }
    }

    @Override
    public void savePost(Post post) {
        if (post == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post must not be null");
        }
        postRepository.save(post);
    }

    @Override
    public void updatePost(Post post, Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID must not be null");
        }
        if (!postRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
        post.setId(id);
        postRepository.save(post);
    }

    @Override
    public void updatePostTitle(String title, Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setTitle(title);
            postRepository.save(post);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
    }

    @Override
    public void updatePostContent(String content, Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setContent(content);
            postRepository.save(post);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
    }

    @Override
    public void deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
    }
}
