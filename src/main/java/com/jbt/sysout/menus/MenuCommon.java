package com.jbt.sysout.menus;

public class MenuCommon {

    public static int getUserChoice() {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            return choice;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return -1;
        }
    }

}
