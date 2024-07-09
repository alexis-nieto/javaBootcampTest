package com.jbt.sysout.printers.menus;

public class PrinterMenuMain {

    public static void printMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to the Book Management Application!\n");
        sb.append("Please select an option:\n");
        sb.append("1. Manage Books\n");
        sb.append("2. Manage Members\n");
        sb.append("3. Manage Loans\n");
        sb.append("4. Exit\n");
        sb.append("Enter your choice (1-4): ");
        System.out.print(sb.toString());    
    }

}
