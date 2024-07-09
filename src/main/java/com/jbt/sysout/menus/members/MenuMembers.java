package com.jbt.sysout.menus.members;

import java.util.Scanner;

import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.menus.PrinterMenuMembers;

public class MenuMembers {

    private static Scanner scanner = new Scanner(System.in);

    public static void displayMemberMenu() {

        boolean quit = false;

        while (!quit) {

            PrinterCommon.clearScreen();
            PrinterMenuMembers.printMemberMenu();

            String choice = scanner.nextLine();
            //System.out.println("You picked: " + choice);

            switch (choice) {
                case "1":
                    // Add Member
                    break;
                case "2":
                    // Update Member
                    break;
                case "3":
                    // Delete Member
                    break;
                case "4":
                    // View Members
                    break;
                case "5":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue; // Restart the loop to ask for input again
            }
        }
        PrinterCommon.clearScreen();
    }
}
