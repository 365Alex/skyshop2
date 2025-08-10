package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchable.Searchable;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int count = 0;


    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }


    public void add(Searchable searchable) {
        if (count < searchableItems.length) {
            searchableItems[count++] = searchable;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.searchTerm().contains(term)) {
                if (resultCount < results.length) {
                    results[resultCount++] = item;
                } else {
                    break;
                }
            }
        }
        return results;
    }
    public Searchable bestFoundMatch(String search) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;
        for (Searchable s : searchableItems) {
            int count = 0;
            int index = 0;
            int indexString=s.searchTerm().indexOf(search,index);
            while (indexString!=-1){
                count++;
                index=indexString+search.length();
                indexString=s.searchTerm().indexOf(search,index);
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
