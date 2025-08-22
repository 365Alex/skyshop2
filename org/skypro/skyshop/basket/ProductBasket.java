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
        Iterator iterator = productMap.values().iterator();
        while (iterator.hasNext()){
            Product product = (Product) iterator.next();
            if (product.getName().equalsIgnoreCase(name)){
                deleteProduct.add(product);
                iterator.remove();
            }
        }
        return deleteProduct;
    }

    public int getTotalPrice(){
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += productMap.values().getPrice();
        }
        return total;
    }



    public void printProductBasket(){
        
            if (size == 0){
                System.out.println("В корзине пусто");
                return;
            }
        for (int i = 0; i < size; i++) {
            System.out.println(productMap.get(i).toString());
        }

        int specialCount = 0;
                for (int i = 0; i < size; i++) {
            if (productMap.values().isSpecial()){
                specialCount ++;
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
