package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {

    private final String title;
    private final String text;

    public Article (String articleTitle, String text){
        this.title = articleTitle;
        this.text = text;
    }



    public String getTitle(){
        return title;
    }

    public String getTextOfTheArticle(){
        return text;
    }

    public String toString(){
        return "Название статьи: " + title + "\n" + " Текст статьи: " + text;
    }


    @Override
    public String searchTerm(){
        return toString();
    }

    @Override
    public String getContent(){
        return "ARTICLE";
    }

    @Override
    public String getName(){
        return title;
    }

}
