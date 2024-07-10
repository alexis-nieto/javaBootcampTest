package com.jbt.db.drivers;
import org.junit.jupiter.api.Test;

import com.jbt.db.containers.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BooksTest {
    
    @Test
    public void testBookAdd() {

    	Books books = new Books();
		Book book = new Book();

		book.setIsbn("9780061124654");
		book.setTitle("Economic Problems of Socialism in the USSR ");
		book.setAuthor("Joseph Stalin");
		book.setPublisher("USSR Ministry of Culture");
		book.setPublicationYear(1952);
		book.setPageCount(132);
		book.setStockQuantity(7);
		book.setGenre("Politics");
		book.setLanguage("Russian");

		books.addBook(book);
        assertEquals("Economic Problems of Socialism in the USSR ", book.getTitle());
        assertEquals("Joseph Stalin", book.getAuthor());
        assertEquals(1952, book.getPublicationYear());
        assertEquals("9780061124654", book.getIsbn());
        assertEquals(true, books.checkIfExists(book));

    }

    @Test
    public static void testBookDelete() {

        Books books = new Books();
		Book book = new Book();

		book.setIsbn("9780061124654");

		books.deleteBook(book);

        assertEquals(false, books.checkIfExists(book));


    }

}