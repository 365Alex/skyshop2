package org.skypro.skyshop.fixPriceproduct;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private final int fixPrice = 78;

    public FixPriceProduct(String name){
        super(name);
    }
    @Override
    public int getPrice(){
        return fixPrice;

    }

    @Override
    public String toString(){
        return "Продукт с фиксированной ценой: " + this.getNameProduct() + " фиксированная цена: " + this.fixPrice + " руб.";
    }


    @Override
    public boolean isSpecial(){
        return true;
    }

}
