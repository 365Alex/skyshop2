package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableItems;


    public SearchEngine() {
        searchableItems = new HashSet<>();

    }


    public void add(Searchable searchable) {
        searchableItems.add(searchable);
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> result = searchableItems.stream()
                .filter(i -> i.searchTerm().contains(term))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
        return result;
    }

    public Searchable bestFoundMatch (String search) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;
        for (Searchable s : searchableItems) {
            int count = 0;
            int index = 0;
            if (s != null) {
                int indexString = s.searchTerm().indexOf(search, index);

                while (indexString != -1) {
                    count++;
                    index = indexString + search.length();
                    indexString = s.searchTerm().indexOf(search, index);
                }
            }
            if (count > maxCount) {
                maxCount = count;
                searchable=s;
            }
        }
        if (maxCount==0) {
            throw new BestResultNotFound();
        }
        return searchable;
    }
}
