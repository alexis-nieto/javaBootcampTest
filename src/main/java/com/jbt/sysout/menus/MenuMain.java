package com.jbt.sysout.menus;

import java.util.Scanner;

import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.menus.books.MenuBooks;
import com.jbt.sysout.menus.loans.MenuLoans;
import com.jbt.sysout.menus.members.MenuMembers;
import com.jbt.sysout.printers.menus.*;

public class MenuMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayMainMenu() {

        PrinterMenuMain.printMainGreeting();

        boolean exit = false;

        while (!exit) {

            PrinterMenuMain.printMainMenu();

            String choice = scanner.nextLine().toLowerCase();
            //System.out.println("You picked: " + choice);

            switch (choice) {
                case "1":
                    PrinterCommon.clearScreen();
                    MenuBooks.displayBookMenu();
                    continue;
                case "2":
                    PrinterCommon.clearScreen();
                    MenuMembers.displayMemberMenu();
                    continue;
                case "3":
                    PrinterCommon.clearScreen();
                    MenuLoans.displayLoanMenu();
                    continue;
                case "4":
                    System.out.println("\nExiting Book Management Application...\n");
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

    public static void displayExitMessage() {
        System.out.println("\nThank you for using the Book Management Application. Goodbye!");
        scanner.close();
    }

}
