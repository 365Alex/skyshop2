package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> products;
    private int size;

    public ProductBasket() {
        this.products = new LinkedList<>();
        size = 0;
    }


    public void addProduct(Product product) {
        if (product != null) {
            size++;
            products.add(product);
        } else {
            System.out.println("Нельзя добавить null продукт");
        }
    }

    public List<Product> deleteNameProduct(String name){
        List<Product> deleteProduct = new LinkedList<>();
        Iterator iterator = products.iterator();
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
            total += products.get(i).getPrice();
        }
        return total;
    }



    public void printProductBasket(){
        
            if (size == 0){
                System.out.println("В корзине пусто");
                return;
            }
        for (int i = 0; i < size; i++) {
            System.out.println(products.get(i).toString());
        }

        int specialCount = 0;
                for (int i = 0; i < size; i++) {
            if (products.get(i).isSpecial()){
                specialCount ++;
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Количество специальных товаров: " + specialCount);


    }



    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getNameProduct().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.size(); i++) {
            products.set(i, null);
        }
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null){
                size = 0;
            }
        }
    }
}
