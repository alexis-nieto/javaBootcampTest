package com.jbt.sysout.menus.loans;

import java.util.Scanner;

import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.menus.PrinterMenuLoans;

public class MenuLoans {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayLoanMenu() {

        boolean exit = false;

        while (!exit) {

            PrinterMenuLoans.printLoanMenu();

            String choice = scanner.nextLine();
            //System.out.println("You picked: " + choice);

            switch (choice) {
                case "1":
                    // Add Loan
                    PrinterCommon.clearScreen();
                    MenuLoansBorrow.borrowBook();
                    continue;
                case "2":
                    // retun Loan
                    continue;
                case "3":
                    // view Loan
                    continue;
                case "4":
                    exit = true;
                    continue;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Restart the loop to ask for input again
            }
        }
    }
}
