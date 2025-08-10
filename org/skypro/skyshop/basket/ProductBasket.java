package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products;
    private int size;

    public ProductBasket(int basket) {
        products = new Product[basket];
        size = 0;
    }


    public void addProduct(Product product) {

        if (size < products.length) {
            products[size++] = product;
        } else  {
            System.out.println("Корзина заполнена");
        }
    }



    public int getTotalPrice(){
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }



    public void printProductBasket(){
        
            if (size == 0){
                System.out.println("В корзине пусто");
                return;
            }
        for (int i = 0; i < size; i++) {
            System.out.println(products[i].toString());
        }

        int specialCount = 0;
                for (int i = 0; i < size; i++) {
            if (products[i].isSpecial()){
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
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null){
                size = 0;
            }
        }
    }
}
