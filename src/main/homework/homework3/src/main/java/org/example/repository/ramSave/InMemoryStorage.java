package org.example.repository.ramSave;

import org.example.entity.Product;
import org.example.repository.Repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage implements Repository{
    private Map<String, Product> products = new HashMap<>();

    @Override
    public void saveProduct(Product product) {
        products.put(product.getArticle(), product);
    }

    @Override
    public Map<String, Product> showAll() {
        return products;
    }

    @Override
    public void updateProduct(String article, Product product) {

    }

    @Override
    public void deleteProduct(String article) {

    }


}
