package com.krieghb.library.controllers;

/**
 * Created by krido02 on 11/16/2015.
 */

import java.util.*;

import com.krieghb.library.business.BookBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.krieghb.library.models.BookModel;
import com.krieghb.library.utilities.LibraryConstants;


@Controller
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger( BookController.class );

    BookBusiness allBooks = new BookBusiness();

    public BookController() {
        BookModel book;

        book = new BookModel();
        book.setTitle("Moby Dick");
        book.setAuthor("Herman Melville");
        book.setReleaseDate("1851");
        book.setKeywords("Call me Ishmal");
        allBooks.addBook(book);

        book = new BookModel();
        book.setTitle("Hitchiker's Guide to the Galaxy");
        book.setAuthor("Douglas Adams");
        book.setReleaseDate("1979");
        book.setKeywords("Bring a towel.");
        allBooks.addBook(book);

        book = new BookModel();
        book.setTitle("Eye of the World");
        book.setAuthor("Robert Jordan");
        book.setReleaseDate("1990");
        book.setKeywords("Eye.");
        allBooks.addBook(book);

        book = new BookModel();
        book.setTitle("Hunt for the Horn");
        book.setAuthor("Robert Jordan");
        book.setReleaseDate("1991");
        book.setKeywords("Hunt.");
        allBooks.addBook( book );

        book = new BookModel();
        book.setTitle("Dragon Reborn");
        book.setAuthor("Robert Jordan");
        book.setReleaseDate("1992");
        book.setKeywords("Dragon.");
        allBooks.addBook( book );
    }


    //  Happy test.
    @RequestMapping( value = LibraryConstants.DUMMY_BOOK, method = RequestMethod.GET )
    public @ResponseBody BookModel getDummyBook() {
        logger.info("Starting/Creating dummy book ( getDummyBook() )");

        BookModel book = new BookModel();
        book.setBookID( 999999 );
        book.setTitle("Dummy Books for Dummies" );
        book.setAuthor("All the Dummies" );
        book.setReleaseDate("1900");
        book.setKeywords( "Dummy DUMMY dummy DuMmY" );

        return book;

    }


    @RequestMapping( value = "/library/books/{id}", produces = "application/json", method = RequestMethod.GET )
    public @ResponseBody Map<String, String> getABook( @PathVariable( "id" ) int id ) {
        logger.info("Getting a single book ( getABook() )");

        Map<String, String> retResult = new HashMap<String, String>();

        retResult = allBooks.getABook( id );

        return retResult;
    }


    @RequestMapping( value = LibraryConstants.GET_ALL_BOOKS, produces = "application/json", method = RequestMethod.GET )
    public @ResponseBody List<BookModel> getAllBooks() {
        logger.info("Getting all books in library ( getAllBooks() )");

        List<BookModel> listBooks = allBooks.getAllBooks();

        return listBooks;

    }


    @RequestMapping( value = "/library/books", method = RequestMethod.POST )
    public @ResponseBody BookModel createBook( @RequestBody BookModel book ) {
        logger.info( "Creating a new book ( createBook() ):  " + book.getTitle() );
        book = allBooks.addBook( book );

        return book;
    }

    @RequestMapping( value = "/library/books/{id}", method = RequestMethod.DELETE )
    public @ResponseBody Map deleteBook( @PathVariable( "id" ) int bookID ) {
        logger.info( "Deleting an existing book by ID ( deleteBook() ):  " );

        BookModel book = allBooks.deleteBook( bookID );
        Map retResult = new HashMap();

        if ( book == null ) {
            retResult.put("success", "false");
        }
        else {
            retResult = allBooks.getBookMap( book );
            retResult.put("success", "true");
        }

        return retResult;

    }

    @RequestMapping( value = "/library/books/{id}", produces = "application/json", method = RequestMethod.PUT )
    public @ResponseBody Map updateBook( @PathVariable( "id" ) int bookID ) {

        logger.info( "Updating an existing book by ID ( udpateBook() ):  " );
        Map retResult = new HashMap();
        BookModel book = allBooks.updateBook( bookID );


        return retResult;

    }




}
