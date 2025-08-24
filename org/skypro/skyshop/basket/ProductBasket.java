package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productMap = new TreeMap<>();
    private int size;

    public ProductBasket(){
        this.size = 0;
    }

    public void addProduct(Product product) {
        List<Product> products;
        if (!productMap.containsKey(product.getName())) {
            products = new LinkedList<>();
            productMap.put(product.getName(), products);
        } else {
            products = productMap.get(product.getName());
        }
        products.add(product);
        size++;
    }

    public String deleteNameProduct(String name){
        productMap.remove(name);
        return "удалённый товар: "+name;

    }



    public int getTotalPrice(){
        int total = 0;
        for (List<Product> value : productMap.values()) {
            for (Product product : value) {
                total += product.getPrice();
            }
        }
        return total;
    }



    public void printProductBasket(){

            if (size == 0){
                System.out.println("В корзине пусто");
                return;
            }
        for (List<Product> value : productMap.values()) {
            for (Product product : value) {
                System.out.println(product.toString());
            }
        }

        int specialCount = 0;
        for (List<Product> value : productMap.values()) {
            for (Product product : value) {
            if (product.isSpecial()) {
                specialCount++;
            }
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Количество специальных товаров: " + specialCount);


    }



    public boolean hasProduct(String name) {
        return productMap.containsKey(name);
    }

    public void clear() {
        productMap.clear();
        size = 0;
    }
}
