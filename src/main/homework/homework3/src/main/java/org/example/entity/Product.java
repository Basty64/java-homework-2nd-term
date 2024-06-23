package org.example.entity;

public class Product {
    private String article;
    private String name;
    private double price;
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
