package org.example;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class Homework2 {
    private static Map<String, Product> database = new HashMap<>();
    public void call() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("----------------------------------------");
                System.out.println("Введите команду (create, read, update, delete, exit)");
                System.out.println("Для справки по командам напишите help");
                String command = scanner.nextLine();

                if (command.startsWith("help")) {
                    System.out.println("----------------------------------------");
                    System.out.println("create - введите артикул, название(в кавычках), \n" +
                            "цену и количество товара через пробел");
                    System.out.println("----------------------------------------");
                    System.out.println("read - команда не подразумевает ввод данных");
                    System.out.println("----------------------------------------");
                    System.out.println("update - введите артикул и новые данные по товару из команды create");
                    System.out.println("----------------------------------------");
                    System.out.println("delete - введите артикула продукта, который нужно удалить");
                    System.out.println("----------------------------------------");
                } else if (command.startsWith("create")) {

                    String[] tokens = command.split(" ");

                    if (tokens.length == 5) {
                        String article = tokens[1];
                        String name = tokens[2];
                        double price = Double.parseDouble(tokens[3]);
                        int quantity = Integer.parseInt(tokens[4]);
                        createProduct(article, name, price, quantity);
                    } else {
                        System.out.println("Неправильный формат команды create");
                    }


                } else if (command.equals("read")) {
                    readProducts();
                } else if (command.startsWith("update")) {
                    String[] tokens = command.split(" ");
                    if (tokens.length == 5) {
                        String article = tokens[1];
                        String name = tokens[2];
                        double price = Double.parseDouble(tokens[3]);
                        int quantity = Integer.parseInt(tokens[4]);
                        updateProduct(article, name, price, quantity);
                    } else {
                        System.out.println("Неправильный формат команды update");
                    }
                } else if (command.startsWith("delete")) {
                    String[] tokens = command.split(" ");
                    if (tokens.length == 2) {
                        String article = tokens[1];
                        deleteProduct(article);
                    } else {
                        System.out.println("Неправильный формат команды delete");
                    }
                } else if (command.equals("exit")) {
                    break;
                } else {
                    System.out.println("Неизвестная команда");
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    private static void createProduct(String article, String name, double price, int quantity) {
        if (!database.containsKey(article)) {
            Product product = new Product(article, name, price, quantity);
            database.put(article, product);
            System.out.println("Товар успешно добавлен");
        } else {
            System.out.println("Товар с таким артикулом уже существует");
        }
    }

    private static void readProducts() {
        System.out.println("Список товаров:");
        System.out.println("Артикул | Название | Цена | Количество");
        for (Product product : database.values()) {
            System.out.println(product.getArticle() + " | " + product.getName() + " | " + product.getPrice() + " | " + product.getQuantity());
        }
    }

    private static void updateProduct(String article, String name, double price, int quantity) {
        if (database.containsKey(article)) {
            Product product = new Product(article, name, price, quantity);
            database.put(article, product);
            System.out.println("Информация о товаре обновлена");
        } else {
            System.out.println("Товар с таким артикулом не найден");
        }
    }

    private static void deleteProduct(String article) {
        if (database.containsKey(article)) {
            database.remove(article);
            System.out.println("Товар успешно удален");
        } else {
            System.out.println("Товар с таким артикулом не найден");
        }
    }
}

class Product {
    private String article;
    private String name;
    private double price;
    private int quantity;

    public Product(String article, String name, double price, int quantity) {
        this.article = article;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

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
}