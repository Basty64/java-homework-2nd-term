package org.example.repository.ssdSave;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entity.Product;
import org.example.repository.Repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataStorage implements Repository {


    private File databaseFile;
    private ObjectMapper objectMapper = new ObjectMapper();



    @Override
    public void saveProduct(Product product) throws IOException {


        HashMap<String, Product> products = objectMapper.readValue(databaseFile, HashMap.class);
        products.put(product.getArticle(), product);

        objectMapper.writeValue(databaseFile, products);


    }

    @Override
    public void showAll() throws IOException {

        HashMap<String, Product> products = objectMapper.readValue(databaseFile, HashMap.class);
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            System.out.println("||" + entry.getKey() + "||" + entry.getValue() + "||");
        }

    }

    @Override
    public void updateProduct(String article, Product product) {

    }

    @Override
    public void deleteProduct(String article) {

    }

    public DataStorage(String filePath) {
        this.databaseFile = new File(filePath);
    }

}


