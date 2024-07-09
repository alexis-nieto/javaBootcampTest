package com.jbt.sysout.printers.menus;

public class PrinterMenuBooks {

    public static void printBookMenu() {

        StringBuilder sb = new StringBuilder();
        sb.append("--- Book Management Menu ---\n");
        sb.append("1. Add Book\n");
        sb.append("2. Update Book\n");
        sb.append("3. Delete Book\n");
        sb.append("4. View Books\n");
        sb.append("5. Return to Main Menu\n");
        sb.append("Enter your choice (1-5): ");
        System.out.print(sb.toString());
    }

}
