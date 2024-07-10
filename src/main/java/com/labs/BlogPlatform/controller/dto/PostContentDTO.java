package com.labs.BlogPlatform.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostContentDTO {
    @NotBlank
    private String content;
}
