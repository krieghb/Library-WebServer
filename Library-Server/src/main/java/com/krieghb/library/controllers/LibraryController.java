package com.krieghb.library.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;


/**
 * Created by krido02 on 11/16/2015.
 */

@RestController
@RequestMapping( value = "/library" )
public class LibraryController {

    Map<String, String> myMap;


    public LibraryController() {
        this( "HI THERE EVERYBODY!" );

    }

    public LibraryController(String hi) {
        System.out.println(hi);
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public String getTest() {
        return "Library Example.";
    }




    @RequestMapping( value = "/{book}", method = RequestMethod.GET )
    public String getBook( @PathVariable ( "book" ) String bookName ) {

        StringBuilder returnBook = new StringBuilder("Book:  ");

        returnBook.append(bookName);

        if ( myMap.isEmpty() ) {
            System.out.println("MyMap is empty.");
        }

        return returnBook.toString();
    }


    @RequestMapping( "/test" )
    public String blankTest() {
        return "Blank Test";
    }



    @RequestMapping( value = "/makeBook/{book}", method = RequestMethod.POST)
    public Map<String, String> makeBook( @PathVariable ( "book" ) String book ) {
        myMap.put( book, book);

        for (Map.Entry<String, String> entry : myMap.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

        return myMap;
    }
}




