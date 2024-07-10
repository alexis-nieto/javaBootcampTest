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

        System.out.print("Enter the book ID to delete: ");
        book.setIsbn(scanner.nextLine());

        PrinterCommon.clearScreen();
        books.deleteBook(book);

    }

}
