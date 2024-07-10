package com.labs.BlogPlatform.service.interfaces;

import com.labs.BlogPlatform.model.Post;

import java.util.List;

public interface IPostService {

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post getPostByTitle(String title);

    List<Post> getPostByContentContaining(String keyword);

    void savePost(Post post);

    void updatePost(Post post, Long id);

    void updatePostTitle(String title, Long id);

    void updatePostContent(String content, Long id);

    void deletePost(Long id);
}
