package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixPriceproduct.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchengine.BestResultNotFound;
import org.skypro.skyshop.searchengine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.*;


public class App {
    public static void main(String[] args) {


        System.out.println("Корзина №1");
        ProductBasket productBasket = new ProductBasket();
        DiscountedProduct cheese = new DiscountedProduct("сыр", 85, 10);
        FixPriceProduct productTwo = new FixPriceProduct("Печенье");
        SimpleProduct productTree = new SimpleProduct("молоко", 94);
        DiscountedProduct productFor = new DiscountedProduct("колбаса", 189, 15);
        SimpleProduct productFife = new SimpleProduct("макароны", 58);

        Map<Product, Product> basketOne = new HashMap<>();
        basketOne.put(cheese, productTwo);
        basketOne.put(productTree, productFor);
        System.out.println(basketOne);

        productBasket.addProduct(cheese);
        productBasket.addProduct(productFife);
        productBasket.addProduct(productTree);
        productBasket.addProduct(productFor);
        productBasket.addProduct(productTwo);
        productBasket.printProductBasket();
        System.out.println(productBasket.deleteNameProduct("сыр"));
//        System.out.println();
//        System.out.println(("Есть ли огурцы в корзине? " + productBasket.hasProduct("огурцы")));
//        System.out.println(("Есть ли сыр в корзине? " + productBasket.hasProduct("сыр")));

        productBasket.clear();
        productBasket.printProductBasket();

        System.out.println();

        System.out.println("Корзина №2");
        ProductBasket productBasketTwo = new ProductBasket();
        SimpleProduct correct = null;

        try {
            correct = new SimpleProduct("", 0);
        } catch (IllegalArgumentException e){
            System.out.println("ошибка создания SimpleProduct");
        }

        SimpleProduct tea = null;

        try {
            tea  = new SimpleProduct("чай", 35);

        } catch (IllegalArgumentException e){
            System.out.println("ошибка создания SimpleProduct " + e.getMessage());
        }
        if (tea != null){
            System.out.println("Продукт успешно создан: " + tea.getName());
        }
            DiscountedProduct candies = new DiscountedProduct("чай с бергамотом", 89, 10);
            DiscountedProduct coffee = new DiscountedProduct("кофе", 198, 10);

            productBasketTwo.addProduct(tea);
            productBasketTwo.addProduct(candies);
            productBasketTwo.addProduct(coffee);
            productBasketTwo.printProductBasket();



        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(candies);
        searchEngine.add(tea);
        searchEngine.add(coffee);
        System.out.println();


        try {
            searchEngine.bestFoundMatch("хлеб");
        } catch (BestResultNotFound e) {
            System.out.println("не найдено" + " " + e.getMessage());
        }


            Article articleOne = new Article("Новинки автомобилей", "Топ 5 автомобилей 2025");
            Article articleTwo = new Article("Рецепт вкусных блинчиков", "Топ 10 рецептов блинчиков");




    }
}
