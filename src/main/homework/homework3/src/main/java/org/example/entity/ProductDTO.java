package org.example.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public class ProductDTO {
    @NotBlank
    private String article;
    @NotBlank
    private String name;
    @NotBlank
    private double price;
    @NotBlank
    private int quantity;
}
