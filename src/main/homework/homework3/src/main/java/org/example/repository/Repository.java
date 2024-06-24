package org.example.repository;


import org.example.entity.Product;

import java.io.IOException;

@org.springframework.stereotype.Repository
public interface Repository  {
void saveProduct(Product product) throws IOException;
   void showAll() throws IOException;
    void updateProduct(String article, Product product);
    void deleteProduct(String article);
}
//прописать здесь выбор через проперти

