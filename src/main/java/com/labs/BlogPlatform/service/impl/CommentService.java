package com.labs.BlogPlatform.service.impl;

import com.labs.BlogPlatform.model.Comment;
import com.labs.BlogPlatform.repository.CommentRepository;
import com.labs.BlogPlatform.service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        if (comments.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No comments found");
        }
        return comments;
    }

    @Override
    public void saveComment(Comment comment) {
        if (comment == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post must not be null");
        }
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with Id: " + id + " not found");
        }
    }
}
