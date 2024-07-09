package com.jbt.sysout.menus.books;

import java.util.Scanner;

import com.jbt.db.containers.Book;
import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;

public class MenuBookAdd {

    private static Scanner scanner = new Scanner(System.in);

    public static void addNewBook() {

        PrinterCommon.clearScreen();

        System.out.println(">>> Adding new Book");

        Books books = new Books();
        Book book = new Book();
        
        // Prompt user for book details
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        book.setIsbn(isbn);
        
        if ( books.checkIfExists(book) ) {
            PrinterCommon.clearScreen();
            System.out.println("\nBook already exists in the database.\n");
        } else {

            System.out.print("Title: ");
            String title = scanner.nextLine();
            book.setTitle(title);
    
            System.out.print("Author: ");
            String author = scanner.nextLine();
            book.setAuthor(author);
    
            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();
            book.setPublisher(publisher);
    
            System.out.print("Publication Year: ");
            int publicationYear = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            book.setPublicationYear(publicationYear);
    
            System.out.print("Page Count: ");
            int pageCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            book.setPageCount(pageCount);
    
            System.out.print("Stock Quantity: ");
            int stockQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            book.setStockQuantity(stockQuantity);
    
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            book.setGenre(genre);
    
            System.out.print("Language: ");
            String language = scanner.nextLine();
            book.setLanguage(language);
    
            PrinterCommon.clearScreen();
    
            books.addBook(book);

        }

    }
}


