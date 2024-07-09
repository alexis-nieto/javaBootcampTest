package com.jbt.sysout.printers.menus;

public class PrinterMenuMembers {

    public static void printMemberMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Member Menu ---\n");
        sb.append("1. Add Member\n");
        sb.append("2. Update Member\n");
        sb.append("3. Delete Member\n");
        sb.append("4. View Members\n");
        sb.append("5. Return to Main Menu\n");
        sb.append("\nEnter your choice (1-5): ");
        System.out.print(sb.toString());    
    }

}
