package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.Searchable;

import java.util.List;
import java.util.Objects;

public abstract class  Product implements Searchable {
    private String name;

    public Product(String name){
    this.name = name;
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("некорректное название продукта");
        }

    }

    public String getNameProduct(){
        return this.name;
    }

    public abstract int getPrice();

    public abstract String toString();

    @Override
    public String searchTerm(){
        return getNameProduct();
    }

    @Override
    public String getContent(){
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;

    }

    public String isBlank(){
        return name;
    }

    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
       Product product = (Product) obj;
        return name.equals(product.name);
    }
    public int hashCode(){
        return Objects.hash(name);
    }

    public abstract boolean isSpecial();
}
