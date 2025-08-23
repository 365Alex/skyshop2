package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class SearchEngine {
    private Map<Searchable, List<Searchable>> searchableItems = new TreeMap<>();

    public SearchEngine(Map<Searchable, List<Searchable>> searchableItems) {
        this.searchableItems = searchableItems;
    }


    public void get(Searchable searchable) {
        searchableItems.get(searchable);
    }

    public Map<Searchable, List<Searchable>> search(String term) {
       Map<Searchable, List<Searchable>> result = new TreeMap<>();
        for(Map.Entry<Searchable, List<Searchable>> searchable : searchableItems) {
            if (searchable != null && searchable.searchTerm().contains(term)) {
                result.get(searchable);
            }
        }
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
