package org.example.repository.ssdSave;

import org.example.entity.Product;
import org.example.repository.Repository;

import java.util.Map;

public class DataStorage implements Repository {


    private File databaseFile;
    private ObjectMapper objectMapper = new ObjectMapper();

    public FileDatabase(String filePath) {
        this.databaseFile = new File(filePath);
    }


    @Override
    public void saveProduct(Product product) {


        HashMap<String, Product> products = objectMapper.readValue(databaseFile, HashMap.class);
        products.put(product.getArticle(), product);

        objectMapper.writeValue(databaseFile, products);


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
