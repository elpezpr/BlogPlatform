package com.labs.BlogPlatform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;

    public Comment(String content, Post post) {
        this.content = content;
        this.post = post;
    }
}
