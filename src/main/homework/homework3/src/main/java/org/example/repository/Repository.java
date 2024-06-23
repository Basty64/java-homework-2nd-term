package org.example.repository;


import org.example.entity.Product;

import java.util.Map;

@org.springframework.stereotype.Repository
public interface Repository  {
void saveProduct(Product product);
    Map<String, Product> showAll();
    void updateProduct(String article, Product product);
    void deleteProduct(String article);
}
//прописать здесь выбор через проперти

