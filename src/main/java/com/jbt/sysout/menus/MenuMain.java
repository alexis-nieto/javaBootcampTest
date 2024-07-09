package com.jbt.sysout.menus;

import com.jbt.sysout.menus.books.MenuBooks;
import com.jbt.sysout.menus.loans.MenuLoans;
import com.jbt.sysout.menus.members.MenuMembers;
import com.jbt.sysout.printers.menus.*;


public class MenuMain {

    public static void displayMainMenu() {
        
        PrinterMenuMain.printMainMenu();

        int choice = MenuCommon.getUserChoice();

        switch (choice) {
            case 1:
                MenuBooks.displayMemberMenu();    
                break;
            case 2:
                MenuMembers.displayMemberMenu();    
                break;
            case 3:
                MenuLoans.displayLoanMenu();    
                break;
            case 4:
                System.out.println("Exiting Book Management Application...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }

    public static void displayExitMessage() {
        System.out.println("\nThank you for using the Book Management Application. Goodbye!");
    }

}
