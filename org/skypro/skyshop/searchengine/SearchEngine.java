package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<SearchEngine> searchableItems;
    private int count = 0;


    public SearchEngine() {
        searchableItems = new LinkedList<>();
    }


    public void add(Searchable searchable) {
        if (count < searchableItems.size()) {
            count++;
            searchableItems.set(count, (SearchEngine) searchable);
        }
    }

    public List<Searchable> search(String term) {
        Iterator<SearchEngine> iterator = searchableItems.iterator();
        List<Searchable> result = new LinkedList<>();
        int count = 0;
        while (iterator.hasNext()){
            if (iterator.next().searchTerm().contains(term)) {
                Searchable s = (Searchable) iterator.next();
                result.add(s);
                count++;
                if (count == 5) {
                    break;
                }
        }
    }

    public Searchable bestFoundMatch(String search) throws BestResultNotFound {
        Searchable searchable = null;
        int maxCount = 0;
        for (SearchEngine s : searchableItems) {
            int count = 0;
            int index = 0;
            if (s != null) {
                int indexString = s.searchTerm().indexOf(search, index);

                while (indexString != -1) {
                    count++;
                    index = indexString + search.length();
                    indexString = s.getSearchTerm().indexOf(search, index);
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
