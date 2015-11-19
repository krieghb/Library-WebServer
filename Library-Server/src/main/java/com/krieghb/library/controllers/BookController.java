package com.krieghb.library.controllers;

/**
 * Created by krido02 on 11/16/2015.
 */


import java.awt.print.Book;
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

    //  Map to store books,  (Will update to database later).
//    Map<Integer, BookModel> library = new HashMap<Integer, BookModel>();

    public BookController() {
        BookModel book;

        book = new BookModel();
//        book.setBookID(1);
        book.setTitle("Moby Dick");
        book.setAuthor("Herman Melville");
        book.setReleaseDate("1851");
        book.setKeywords("Call me Ishmal");
//        library.put(book.getBookID(), book);
        allBooks.addBook(book);

        book = new BookModel();
//        book.setBookID(2);
        book.setTitle("Hitchiker's Guide to the Galaxy");
        book.setAuthor("Douglas Adams");
        book.setReleaseDate("1979");
        book.setKeywords("Bring a towel.");
//        library.put( book.getBookID(), book );
        allBooks.addBook(book);

        book = new BookModel();
//        book.setBookID(3);
        book.setTitle("Eye of the World");
        book.setAuthor("Robert Jordan");
        book.setReleaseDate("1990");
        book.setKeywords("Eye.");
//        library.put( book.getBookID(), book );
        allBooks.addBook(book);

        book = new BookModel();
//        book.setBookID(4);
        book.setTitle("Hunt for the Horn");
        book.setAuthor("Robert Jordan");
        book.setReleaseDate("1991");
        book.setKeywords("Hunt.");
//        library.put( book.getBookID(), book );
        allBooks.addBook( book );

        book = new BookModel();
//        book.setBookID(5);
        book.setTitle("Dragon Reborn");
        book.setAuthor("Robert Jordan");
        book.setReleaseDate("1992");
        book.setKeywords("Dragon.");
//        library.put(book.getBookID(), book);
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


//    @RequestMapping( value = "/library/books/{id}", produces = "application/json", method = RequestMethod.GET )
//    public @ResponseBody BookModel getBook( @PathVariable( "id" ) int id ) {
//        logger.info("Getting a single book ( getABook() )");
//
//        return library.get( id );
//    }


    @RequestMapping( value = "/library/books/{id}", produces = "application/json", method = RequestMethod.GET )
    public @ResponseBody Map<String, String> getABook( @PathVariable( "id" ) int id ) {
        logger.info("Getting a single book ( getABook() )");

        Map<String, String> retResult = new HashMap<String, String>();

        retResult = allBooks.getABook( id );

        return retResult;
    }


//    @RequestMapping( value = LibraryConstants.GET_ALL_BOOKS, produces = "application/json", method = RequestMethod.GET )
//    public @ResponseBody List<BookModel> getLibrary() {
//        logger.info( "Getting all books in library ( getLibrary() )" );
//
//        List<BookModel> allBooks = new ArrayList<BookModel>();
//        Set<Integer> bookKeys = library.keySet();
//
//        for ( Integer i : bookKeys ) {
//            BookModel book = library.get( i );
//            allBooks.add( book );
//            logger.info( "Book in Library:  " + book.getTitle() );
//        }
//
//        return allBooks;
//
//    }


    @RequestMapping( value = LibraryConstants.GET_ALL_BOOKS, produces = "application/json", method = RequestMethod.GET )
    public @ResponseBody List<BookModel> getAllBook() {
        logger.info("Getting all books in library ( getAllBooks() )");


        List<BookModel> listBooks = allBooks.getAllBooks();
//        List<BookModel> allBooks = new ArrayList<BookModel>();
//        Set<Integer> bookKeys = library.keySet();
//
//        for ( Integer i : bookKeys ) {
//            BookModel book = library.get( i );
//            allBooks.add( book );
//            logger.info( "Book in Library:  " + book.getTitle() );
//        }

        return listBooks;

    }


    @RequestMapping( value = "/library/books", method = RequestMethod.POST )
    public @ResponseBody BookModel createBook( @RequestBody BookModel book ) {
        logger.info( "Creating a new book ( createBook() ):  " + book.getTitle() );
        book = allBooks.addBook( book );
//        library.put( bID, book );

        return book;
    }


//    @RequestMapping( value = LibraryConstants.DELETE_BOOK, method = RequestMethod.PUT )
//    public @ResponseBody BookModel deleteBook( @PathVariable( "bookID" ) int bookID ) {
//        logger.info( "Deleting an existing book (deleteBook() ):  " + library.get(bookID).getTitle() );
//
//        BookModel book = library.get( bookID );
//        library.remove(bookID);
//
//
//
//        return book;
//
//    }

//    @RequestMapping( value = LibraryConstants.DELETE_BOOK_ID, method = RequestMethod.DELETE )
//    public @ResponseBody BookModel deleteBookID( @PathVariable( "id" ) int bookID ) {
//        logger.info( "Deleting an existing book by ID (deleteBook() ):  " + library.get(bookID).getTitle() );
//
//        BookModel book = library.get( bookID );
//        library.remove( bookID );
//
//        return book;
//
//    }

    @RequestMapping( value = "/library/books/{id}", method = RequestMethod.DELETE )
//    public @ResponseBody BookModel deleteBookID2( @PathVariable( "id" ) int bookID ) {
    public @ResponseBody Map deleteBookID2( @PathVariable( "id" ) int bookID ) {
//        logger.info( "Deleting an existing book by ID ( deleteBook() ):  " + library.get( bookID ).getTitle() );
        logger.info( "Deleting an existing book by ID ( deleteBook() ):  " );

//        BookModel book = library.get( bookID );
        BookModel book = allBooks.deleteBook( bookID );
        Map retResult = new HashMap();

        if ( book == null ) {
            retResult.put("success", "false");
        }
        else {
            retResult = allBooks.getBookMap( book );
            retResult.put("success", "true");
        }

//        library.remove( bookID );

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
