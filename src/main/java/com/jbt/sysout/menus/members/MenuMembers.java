package com.jbt.sysout.menus.members;

import java.util.Scanner;

import com.jbt.db.drivers.Members;
import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.menus.books.MenuBookSearch;
import com.jbt.sysout.printers.menus.PrinterMenuMembers;

public class MenuMembers {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayMemberMenu() {

        boolean quit = false;

        while (!quit) {

            PrinterMenuMembers.printMemberMenu();

            String choice = scanner.nextLine();
            //System.out.println("You picked: " + choice);

            switch (choice) {
                case "1":
                    // Add Member
                    PrinterCommon.clearScreen();
                    MenuMemberAdd.addNewMember();
                    break;
                case "2":
                    // Update Member
                    break;
                case "3":
                    // Delete Member
                    break;
                case "4":
                    // View Members
                    PrinterCommon.clearScreen();
                    MenuMemberSearch.searchMember();
                    break;
                case "5":
                    // View ALL Members
                    Members members = new Members();
                    members.getMembers();
                    break;
                case "6":
                    PrinterCommon.clearScreen();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Restart the loop to ask for input again
            }
        }
    }
}
