package com.krieghb.library.business;

import com.krieghb.library.models.BookModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by krido02 on 11/17/2015.
 */
public class BookBusiness {

    private static final Logger logger = LoggerFactory.getLogger(BookBusiness.class);

    public int bookIdCounter = 1;
    List<BookModel> books = new ArrayList<BookModel>();



    public BookModel addBook( BookModel newBook ) {
        newBook.setBookID(bookIdCounter++);

        books.add(newBook);

        return newBook;
    }

    public Map getABook( int id ) {
        logger.info( "Getting a book by ID: " + id + "and returning Map");
        BookModel retBook = findBook( id );


        Map mapBook = new HashMap( getBookMap( retBook ) );
//        mapBook.put("Book ID", retBook.getBookID());
//        mapBook.put("Title", retBook.getTitle());
//        mapBook.put("Author", retBook.getAuthor());
//        mapBook.put("Publication Date", retBook.getReleaseDate());
//        mapBook.put("Keywords", retBook.getKeywords());

        return mapBook;
    }


    public BookModel getBook( int id ) {
        logger.info( "Getting a book by ID: " + id + "and returning Book");

        BookModel retBook = findBook( id );

        return retBook;
    }


    public List<BookModel> getAllBooks() {
        logger.info( "Getting all books " );
        return books;
    }


    public BookModel deleteBook( int id ) {
        logger.info( "Deleting a book by ID: " + id + "and returning book");
        int removeSuccess = -1;

        BookModel remBook = findBook ( id );

        if ( remBook != null ) {
            removeSuccess = remBook.getBookID();
            books.remove( remBook );
        }

//        return removeSuccess;
        return remBook;
    }


    public BookModel updateBook( int bookID ) {
        logger.info( "Updating a book by ID: " + bookID + "and returning Book");

        BookModel book = findBook( bookID );


        return book;
    }













    public Map getBookMap( BookModel book ) {
        Map returnBook = new HashMap();

        returnBook.put( "Book ID",book.getBookID() );
        returnBook.put( "Title", book.getTitle() );
        returnBook.put( "Author", book.getAuthor() );
        returnBook.put( "Publication", book.getReleaseDate() );
        returnBook.put( "Keywords", book.getKeywords() );

        return returnBook;
    }


    public BookModel findBook( int id ) {
        BookModel foundBook = null;
        for ( BookModel book : books ) {
            if ( book.getBookID() == id ) {
                foundBook = book;
                break;
            }
        }

        return foundBook;
    }



}
