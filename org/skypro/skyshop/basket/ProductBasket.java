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

    public List<Product> deleteNameProduct(String name){
        List<Product> deleteProduct = new LinkedList<>();
        Iterator<Map.Entry<String, List<Product>>> deleteMap = productMap.entrySet().iterator();
        while (deleteMap.hasNext()){
            Map.Entry<String, List<Product>> prodMap = deleteMap.next();
            Product product = (Product) prodMap.getValue();
            if (product.getName().equals(name)){
                System.out.println(product.getNameProduct());
                deleteProduct.add(product);
                deleteMap.remove();
            }
        }
        if (deleteProduct.isEmpty()){
            System.out.printf("такого продукта нет ", name);
        }
        return deleteProduct;
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
        for (List<Product> products : productMap.values()) {
            if (products.get(size).getNameProduct().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        productMap.clear();
        size = 0;
    }
}
