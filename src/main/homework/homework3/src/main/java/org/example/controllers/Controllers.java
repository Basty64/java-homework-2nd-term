package org.example.controllers;

import org.example.entities.Product;
import org.example.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {

    private final Repository repository;

    public Controllers(@Autowired Repository repository) {
        this.repository = repository;
    }

    //    Артикул должен быть уникальным. Можно добавить только один товар с одним артикулом.
    //    Артикул может содержать только цифры и латинские буквы в Upper Case.
    @PostMapping("/product")
    public void addProduct(@RequestBody Product product) {
        repository.addProduct(product);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    @PutMapping("/product/{sku}")
    public void updateProduct(@PathVariable String article, @RequestBody Product product) {
        repository.updateProduct(article, product);
    }

    @DeleteMapping("/product/{sku}")
    public void deleteProduct(@PathVariable String article) {
        repository.deleteProduct(article);
    }
}

