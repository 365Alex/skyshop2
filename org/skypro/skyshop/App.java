package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixPriceproduct.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchengine.BestResultNotFound;
import org.skypro.skyshop.searchengine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class App {
    public static void main(String[] args) {


        System.out.println("Корзина №1");
        ProductBasket productBasket = new ProductBasket();
        DiscountedProduct cheese = new DiscountedProduct("сыр", 85, 10);
        FixPriceProduct productTwo = new FixPriceProduct("Печенье");
        SimpleProduct productTree = new SimpleProduct("молоко", 94);
        DiscountedProduct productFor = new DiscountedProduct("колбаса", 189, 15);
        SimpleProduct productFife = new SimpleProduct("макароны", 58);
        productBasket.printProductBasket();

        List<Product> productBasketOne = new LinkedList<>();
        productBasketOne.add(cheese);
        productBasketOne.add(productFife);
        productBasketOne.add(productTwo);
        productBasketOne.add(productFor);
        productBasketOne.add(productTree);
        System.out.println(productBasketOne);
        System.out.println(productBasketOne.get(3));

        productBasket.addProduct(cheese);
        productBasket.addProduct(productFife);
        productBasket.addProduct(productTree);
        productBasket.printProductBasket();
        System.out.println(productBasket.deleteNameProduct("молоко"));



        System.out.println();
        System.out.println(("Есть ли огурцы в корзине? " + productBasket.hasProduct("огурцы")));
        System.out.println(("Есть ли молоко в корзине? " + productBasket.hasProduct("молоко")));

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
        try {
            searchEngine.bestFoundMatch("хлеб");
        } catch (BestResultNotFound e) {
            System.out.println("не найдено" + e.getMessage());
        }


            Article articleOne = new Article("Новинки автомобилей", "Топ 5 автомобилей 2025");
            Article articleTwo = new Article("Рецепт вкусных блинчиков", "Топ 10 рецептов блинчиков");

            searchEngine.add(articleOne);
            searchEngine.add(articleTwo);






    }
}
