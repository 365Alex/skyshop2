package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

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

    public boolean isSpecial(){
        return false;
    }

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

}
