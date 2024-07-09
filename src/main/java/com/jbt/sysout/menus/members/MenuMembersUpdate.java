package com.jbt.sysout.menus.members;

import java.util.Scanner;

import com.jbt.db.containers.Book;
import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;

public class MenuMembersUpdate {

    private static Scanner scanner = new Scanner(System.in);

    public static void updateBook() {
        
        System.out.println(">>> Updating Book");

        Books books = new Books();
        Book book = new Book();

        System.out.print("Enter ISBN of the book to update: ");
        String isbn = scanner.nextLine();
        book.setIsbn(isbn);

        if (books.checkIfExists(book)) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            while (newTitle.isEmpty()) {
                System.out.print("Title cannot be empty. Please enter a valid title: ");
                newTitle = scanner.nextLine();
            }
            book.setTitle(newTitle);

            System.out.print("Enter new author: ");
            String newAuthor = scanner.nextLine();
            while (newAuthor.isEmpty()) {
                System.out.print("Author cannot be empty. Please enter a valid author: ");
                newAuthor = scanner.nextLine();
            }
            book.setAuthor(newAuthor);

            System.out.print("Enter new publisher: ");
            String newPublisher = scanner.nextLine();
            while (newPublisher.isEmpty()) {
                System.out.print("Publisher cannot be empty. Please enter a valid publisher: ");
                newPublisher = scanner.nextLine();
            }
            book.setPublisher(newPublisher);

            System.out.print("Enter new publication year: ");
            int newPublicationYear = 0;
            boolean validPublicationYear = false;
            while (!validPublicationYear) {
                try {
                    newPublicationYear = Integer.parseInt(scanner.nextLine());
                    validPublicationYear = true;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid publication year. Please enter a valid year: ");
                }
            }
            book.setPublicationYear(newPublicationYear);

            System.out.print("Enter new page count: ");
            int newPageCount = 0;
            boolean validPageCount = false;
            while (!validPageCount) {
                try {
                    newPageCount = Integer.parseInt(scanner.nextLine());
                    validPageCount = true;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid page count. Please enter a valid number: ");
                }
            }
            book.setPageCount(newPageCount);

            System.out.print("Enter new stock quantity: ");
            int newStockQuantity = 0;
            boolean validStockQuantity = false;
            while (!validStockQuantity) {
                try {
                    newStockQuantity = Integer.parseInt(scanner.nextLine());
                    validStockQuantity = true;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid stock quantity. Please enter a valid number: ");
                }
            }
            book.setStockQuantity(newStockQuantity);

            System.out.print("Enter new genre: ");
            String newGenre = scanner.nextLine();
            book.setGenre(newGenre);

            System.out.print("Enter new language: ");
            String newLanguage = scanner.nextLine();
            book.setLanguage(newLanguage);

            PrinterCommon.clearScreen();
            books.updateBook(book);
            //System.out.println("Book updated successfully.");
        } else {
            PrinterCommon.clearScreen();
            System.out.println("Book with the given ISBN does not exist.\n");
        }
    }

}
