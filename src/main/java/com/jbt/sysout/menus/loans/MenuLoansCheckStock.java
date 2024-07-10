package com.jbt.sysout.menus.loans;

import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;

import java.util.Scanner;

import com.jbt.db.containers.Book;

public class MenuLoansCheckStock {

    private static Scanner scanner = new Scanner(System.in);

    public static void checkStock() {
        
        Books books = new Books();
        Book book = new Book();

        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();

        while (isbn.isEmpty() || !isbn.matches("\\d{10,13}")) {
            System.out.print("Invalid ISBN. Please enter a valid ISBN (10-13 digits): ");
            isbn = scanner.nextLine();
        }
        book.setIsbn(isbn);

        // Check if the book exists in the library.
        if (!books.checkIfExists(book)) {

            PrinterCommon.clearScreen();
            System.out.println("The book does not exist in the library.");
            return;

        }

        int stock = books.getStockQuantity(book);

        StringBuilder sb = new StringBuilder();

        PrinterCommon.clearScreen();

        sb.append("The book with ISBN ");
        sb.append(isbn);
        sb.append(" has ");
        sb.append(stock);
        sb.append(" copies available in the library.");

        System.out.println(sb.toString());

    }

}
