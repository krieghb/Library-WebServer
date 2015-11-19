package com.krieghb.library.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by krido02 on 11/16/2015.
 */


public class BookModel {

    @JsonProperty( "id" )
    private int bookID;

    @JsonProperty( "title" )
    private String title;

    @JsonProperty( "author" )
    private String author;

    @JsonProperty( "releaseDate" )
    private String releaseDate;

    @JsonProperty( "keywords" )
    private String keywords;



    public void setBookID( int bookID ) {
        this.bookID = bookID;
    }
    public int getBookID() {
        return bookID;
    }

    public void setTitle( String title ) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setAuthor( String author ) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setReleaseDate( String releaseDate ) {
        this.releaseDate = releaseDate;
    }
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setKeywords( String keywords ) {
        this.keywords = keywords;
    }
    public String getKeywords() {
        return keywords;
    }


}
