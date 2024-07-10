package com.jbt.sysout.printers.menus;

public class PrinterMenuLoans {

    public static void printLoanMenu() {

        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Loan Management Menu ---\n");
        sb.append("1. Borrow Book\n");
        sb.append("2. Return Book\n");
        sb.append("3. View Loans of Member\n");
        sb.append("4. Check book availability\n");
        sb.append("5. Return to Main Menu\n");
        sb.append("Enter your choice (1-5): ");
        System.out.print(sb.toString());
    }

}
