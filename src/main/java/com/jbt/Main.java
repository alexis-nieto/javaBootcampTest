package com.jbt;

import java.util.List;

import com.jbt.db.BookDB;
import com.jbt.db.Config;
import com.jbt.db.containers.Book;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Starting Book Management Application...");
		
		Config.initConfig();

		BookDB bookDB = new BookDB();

		bookDB.getAllBooks();


		/*
		BookDB bookDB = new BookDB();
		Book book = new Book();

		book.setIsbn("9780061124873");
		book.setTitle("The Doors of Heaven");
		book.setAuthor("Pol Pot");
		book.setPublisher("Tamrielic Press");
		book.setPublicationYear(2014);
		book.setPageCount(1500);
		book.setStockQuantity(400);
		book.setGenre("Religion");
		book.setLanguage("Imperial");

		bookDB.addBook(book);


		

		Book book2 = new Book();

		book2.setIsbn("9780060935666");

		bookDB.deleteBook(book2);
*/
	}

}
