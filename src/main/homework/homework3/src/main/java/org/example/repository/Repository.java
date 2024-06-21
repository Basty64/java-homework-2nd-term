package org.example.repository;


import org.example.entities.Product;

import java.util.List;
@org.springframework.stereotype.Repository
public interface Repository  {
    void addProduct(Product product);
    List<Product> getAllProducts();
    void updateProduct(String article, Product product);
    void deleteProduct(String article);
}
//прописать здесь выбор через проперти

