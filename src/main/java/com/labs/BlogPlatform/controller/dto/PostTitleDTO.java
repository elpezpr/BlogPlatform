package com.labs.BlogPlatform.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostTitleDTO {
    @NotBlank
    private String title;
}
