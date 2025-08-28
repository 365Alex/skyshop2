package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    public int compare(Searchable o1, Searchable o2) {
        int lengthCompare = Integer.compare(o1.getName().length(), o2.getName().length());
        if (lengthCompare == 0){
            return o1.getName().compareTo(o2.getName());
        }
        return lengthCompare;
    }
}
