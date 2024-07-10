package com.jbt.sysout.printers.menus;

import com.jbt.sysout.PrinterCommon;

public class PrinterMenuLoans {

    public static void printLoanMenu() {

        PrinterCommon.clearScreen();

        StringBuilder sb = new StringBuilder();
        sb.append("--- Loan Management Menu ---\n");
        sb.append("1. Borrow Book\n");
        sb.append("2. Return Book\n");
        sb.append("3. View Loans\n");
        sb.append("4. Return to Main Menu\n");
        sb.append("Enter your choice (1-4): ");
        System.out.print(sb.toString());
    }

}
