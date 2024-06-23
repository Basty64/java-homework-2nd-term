package org.example.controllers;

import jakarta.validation.Valid;
import org.example.entity.Product;
import org.example.entity.ProductDTO;
import org.example.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controllers {

    private final Repository repository;

    public Controllers(@Autowired Repository repository) {

        this.repository = repository;
    }

    //    Артикул должен быть уникальным. Можно добавить только один товар с одним артикулом.

    @PostMapping("/product")
    public void addProduct(@Valid @RequestBody ProductDTO productDTO) {

        repository.addProduct(productDTO);
    }
    //    Артикул может содержать только цифры и латинские буквы в Upper Case.

    @GetMapping("/product")
    public Map<String, Product> getAllProducts() {

        return repository.getAllProducts();
    }

    @PutMapping("/product/{article}")
    public void updateProduct(@PathVariable String article, @RequestBody Product product) {

        repository.updateProduct(article, product);
    }

    @DeleteMapping("/product/{article}")
    public void deleteProduct(@PathVariable String article) {

        repository.deleteProduct(article);
    }
}

