package com.labs.BlogPlatform.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Article extends Post {
    @NotBlank
    private String topic;

    public Article(String title, String content, String topic) {
        super(title, content);
        this.topic = topic;
    }
}
