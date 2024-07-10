package com.jbt.sysout.printers.menus;

public class PrinterMenuMembers {

    public static void printMemberMenu() {

        StringBuilder sb = new StringBuilder();
        sb.append("--- Member Menu ---\n");
        sb.append("1. Add Member\n");
        sb.append("2. Update Member\n");
        sb.append("3. Delete Member\n");
        sb.append("4. View Members\n");
        sb.append("5. View ALL Members\n");
        sb.append("6. Return to Main Menu\n");
        sb.append("Enter your choice (1-6): ");
        System.out.print(sb.toString());    
    }

    public static void printMemberSearch(){

        StringBuilder sb = new StringBuilder();
        sb.append("--- Search Member Menu ---\n");
        sb.append(" 1. Search by ID\n");
        sb.append(" 2. Search by First Name\n");
        sb.append(" 3. Search by Last Name\n");
        sb.append(" 4. Search by Email\n");
        sb.append(" 5. Search by Phone\n");
        sb.append(" 6. Search by Address\n");
        sb.append(" 7. Search by City\n");
        sb.append(" 8. Search by State\n");
        sb.append(" 9. Search by ZipCode\n");
        sb.append("10. Search by Join Date\n");
        sb.append("Enter your choice (1-10):");
        System.out.print(sb.toString());
    }

}
