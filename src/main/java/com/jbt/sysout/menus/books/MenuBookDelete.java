package com.jbt.sysout.menus.books;

import java.util.Scanner;

import com.jbt.db.containers.Book;
import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;

public class MenuBookDelete {

    public static Scanner scanner = new Scanner(System.in);


    public static void deleteBook() {

        PrinterCommon.clearScreen();

        Books books = new Books();
        Book book = new Book();
        String isbn = null;

        System.out.print("Enter the book ID to delete: ");

        while (true) {
            isbn = scanner.nextLine();
            if (isbn.matches("\\d{10}|\\d{13}")) {
                break;
            }
            System.out.print("Invalid ISBN. Please enter a valid 10 or 13 digit ISBN: ");
        }
        
        book.setIsbn(isbn);

        PrinterCommon.clearScreen();
        books.deleteBook(book);

    }

}
