package org.skypro.skyshop.searchable;

public interface Searchable {

   String searchTerm();

    String getContent();

    default String getStringRepresentation(){
        return getName() + " - " + getContent();
    }

    String getName();


}
