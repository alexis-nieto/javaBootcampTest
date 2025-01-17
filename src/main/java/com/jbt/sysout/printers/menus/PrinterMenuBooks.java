package com.jbt.sysout.printers.menus;

public class PrinterMenuBooks {

    public static void printBookMenu() {

        StringBuilder sb = new StringBuilder();
        sb.append("--- Book Management Menu ---\n");
        sb.append("1. Add Book\n");
        sb.append("2. Update Book\n");
        sb.append("3. Delete Book\n");
        sb.append("4. View Books\n");
        sb.append("5. View ALL Books\n");
        sb.append("6. Return to Main Menu\n");
        sb.append("Enter your choice (1-6): ");
        System.out.print(sb.toString());
    }

    public static void printBookSearch(){

        StringBuilder sb = new StringBuilder();
        sb.append("--- Search Book Menu ---\n");
        sb.append("1. Search by ISBN\n");
        sb.append("2. Search by Title\n");
        sb.append("3. Search by Author\n");
        sb.append("4. Search by Publisher\n");
        sb.append("5. Search by Publication Year\n");
        sb.append("6. Search by Genre\n");
        sb.append("7. Search by Language\n");
        sb.append("Enter your choice (1-7):");
        System.out.print(sb.toString());
    }

}
