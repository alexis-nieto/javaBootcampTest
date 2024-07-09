package com.jbt;

import com.jbt.db.BookDB;
import com.jbt.db.containers.Book;

public class MainTests {

    public static void test_getAllBooks(){

    		BookDB bookDB = new BookDB();

		bookDB.getAllBooks();

    }

    public static void test_addBook(){

    	BookDB bookDB = new BookDB();
		Book book = new Book();

		book.setIsbn("9780061124654");
		book.setTitle("Economic Problems of Socialism in the USSR ");
		book.setAuthor("Joseph Stalin");
		book.setPublisher("USSR Ministry of Culture");
		book.setPublicationYear(1952);
		book.setPageCount(132);
		book.setStockQuantity(564);
		book.setGenre("Politics");
		book.setLanguage("Russian");

		bookDB.addBook(book);

    }

    public static void test_deleteBook() {

        BookDB bookDB = new BookDB();
		Book book = new Book();
		book.setIsbn("9780061124654");
		bookDB.deleteBook(book);

    }

    public static void test_getBooks() {

        BookDB bookDB = new BookDB();
		bookDB.getBooks("language_db","fr");

    }

    public static void test_updateBook() {
        BookDB bookDB = new BookDB();
        Book book = new Book();
        book.setIsbn("9780061124654");
        book.setTitle("Updated Book Title");
        book.setAuthor("Updated Author Name");
        book.setPublisher("Updated Publisher Name");
        book.setPublicationYear(2023);
        book.setPageCount(200);
        book.setStockQuantity(100);
        book.setGenre("Updated Genre");
        book.setLanguage("Updated Language");

        bookDB.updateBook(book);
    }
    
}
