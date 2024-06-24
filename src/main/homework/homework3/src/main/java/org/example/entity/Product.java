package org.example.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public class Product {
    @NotBlank
    private String article;
    @NotBlank
    private String name;
    @NotBlank
    private double price;
    @NotBlank
    private int quantity;

    public String getArticle() {
        return article;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public Product (String article, String name, double price, int quantity){
        this.article = article;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
