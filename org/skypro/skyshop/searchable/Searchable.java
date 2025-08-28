package org.skypro.skyshop.searchable;

import org.skypro.skyshop.product.Product;

import java.util.List;

public interface Searchable {

   String searchTerm();

    String getContent();

    default String getStringRepresentation(){
        return getName() + " - " + getContent();
    }

    String getName();

}
