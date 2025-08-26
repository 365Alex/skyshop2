package org.skypro.skyshop.article;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private String title;
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
        return "Название статьи: " + title + "\n" + " Текст статьи: " + text + "\n";
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

    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Article article = (Article) obj;
        return title.equals(article.title);
    }
    public int hashCode(){
        return Objects.hash(title);
    }

}
