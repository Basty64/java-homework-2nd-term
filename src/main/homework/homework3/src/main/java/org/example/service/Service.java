package org.example.service;

import org.example.entity.Product;
import org.example.repository.Repository;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    @Value("${service.target}")
    private String target;


    public void addProduct(Product product) {
        if (target.equals("ROM")){
//            service.saveToRom(product);
        }
    }

    public Map<String, Product> getAllProducts() {
        if (target.equals("ROM")){
//           service.saveToRom(product);
        }else if (target.equals("SSD")){

        }
        return null;
    }

    public void updateProduct(String article, Product product) {

    }

    public void deleteProduct(String article) {

    }
}
