package com.labs.BlogPlatform.controller.impl;

import com.labs.BlogPlatform.model.Comment;
import com.labs.BlogPlatform.service.impl.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    CommentService commentService;

    // ********** GET **********

    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // ********** POST **********

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(@RequestBody @Valid Comment comment) {
        commentService.saveComment(comment);
    }

    // ********** DELETE **********

    @DeleteMapping("/comment/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}