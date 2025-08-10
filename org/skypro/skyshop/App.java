package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.discountedproduct.DiscountedProduct;
import org.skypro.skyshop.fixPriceproduct.FixPriceProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.searchengine.BestResultNotFound;
import org.skypro.skyshop.searchengine.SearchEngine;
import org.skypro.skyshop.simpleproduct.SimpleProduct;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;



public class App {
    public static void main(String[] args) {


        System.out.println("Корзина №1");
        ProductBasket productBasket = new ProductBasket(5);
        DiscountedProduct cheese = new DiscountedProduct("сыр", 85, 10);
        FixPriceProduct productTwo = new FixPriceProduct("Печенье");
        SimpleProduct productTree = new SimpleProduct("молоко", 94);
        DiscountedProduct productFor = new DiscountedProduct("колбаса", 189, 15);
        SimpleProduct productFife = new SimpleProduct("макароны", 58);


        productBasket.addProduct(cheese);
        productBasket.addProduct(productTwo);
        productBasket.addProduct(productTree);
        productBasket.addProduct(productFor);
        productBasket.addProduct(productFife);
        productBasket.printProductBasket();


        System.out.println();
        System.out.println(("Есть ли огурцы в корзине? " + productBasket.hasProduct("огурцы")));
        System.out.println(("Есть ли молоко в корзине? " + productBasket.hasProduct("молоко")));

        productBasket.clear();
        productBasket.printProductBasket();

        System.out.println();

        System.out.println("Корзина №2");
        ProductBasket productBasketOne = new ProductBasket(5);
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

            productBasketOne.addProduct(tea);
            productBasketOne.addProduct(candies);
            productBasketOne.addProduct(coffee);
            productBasketOne.printProductBasket();



            SearchEngine searchEngine = new SearchEngine(5);
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

            System.out.println(Arrays.toString(searchEngine.search("Новинки")));





    }
}
