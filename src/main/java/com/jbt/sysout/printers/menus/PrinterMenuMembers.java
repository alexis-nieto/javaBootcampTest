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

}
