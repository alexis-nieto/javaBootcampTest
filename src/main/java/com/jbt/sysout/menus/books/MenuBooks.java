package com.jbt.sysout.menus.books;

import java.util.Scanner;

import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.menus.PrinterMenuBooks;

public class MenuBooks {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayBookMenu() {

        boolean exit = false;

        while (!exit) {

            PrinterCommon.clearScreen();
            PrinterMenuBooks.printBookMenu();

            String choice = scanner.nextLine();
            System.out.println("You picked: " + choice);

            switch (choice) {
                case "1":
                    System.out.println("> Adding new Book");
                    break;
                case "2":
                    // Update Book
                    break;
                case "3":
                    // Delete Book
                    break;
                case "4":
                    // View Books
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    PrinterCommon.clearScreen();
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Restart the loop to ask for input again
            }
        }
        PrinterCommon.clearScreen();
    }
}
