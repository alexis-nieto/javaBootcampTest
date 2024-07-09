package com.jbt.sysout.menus.books;

import java.util.Scanner;

import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.menus.PrinterMenuBooks;

public class MenuBooks {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayBookMenu() {

        boolean exit = false;

        while (!exit) {

            PrinterMenuBooks.printBookMenu();

            String choice = scanner.nextLine();
            //System.out.println("You picked: " + choice);

            switch (choice) {
                case "1":
                    // Add Book
                    PrinterCommon.clearScreen();
                    MenuBookAdd.addNewBook();
                    break;
                case "2":
                    // Update Book
                    PrinterCommon.clearScreen();
                    MenuBookUpdate.updateBook();
                    break;
                case "3":
                    // Delete Book
                    PrinterCommon.clearScreen();
                    MenuBookUpdate.updateBook();
                    break;
                case "4":
                    // View Books
                    break;
                case "5":
                    // View All Books
                    Books books = new Books();
                    books.getBooks();
                break;
                case "6":
                    PrinterCommon.clearScreen();
                    exit = true;
                    break;
                default:
                    //PrinterCommon.clearScreen();
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Restart the loop to ask for input again
            }
        }
    }
}
