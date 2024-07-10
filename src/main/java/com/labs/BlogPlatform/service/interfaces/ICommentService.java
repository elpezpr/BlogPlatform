package com.labs.BlogPlatform.service.interfaces;

import com.labs.BlogPlatform.model.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> getAllComments();

    void saveComment(Comment comment);

    void deleteComment(Long id);
}
