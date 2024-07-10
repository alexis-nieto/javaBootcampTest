package com.jbt.sysout.menus.members;

import java.util.Scanner;

import com.jbt.db.containers.Member;
import com.jbt.db.drivers.Members;
import com.jbt.sysout.PrinterCommon;

public class MenuMemberUpdate {

    private static Scanner scanner = new Scanner(System.in);

    public static void updateMember() {
        
        System.out.println(">>> Updating Member");

        Members members = new Members();
        Member member = new Member();

        System.out.print("Enter ID of the member to update: ");
        int id = 0;
        boolean validId = false;
        while (!validId) {
            try {
                id = Integer.parseInt(scanner.nextLine());
                validId = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid ID. Please enter a valid number: ");
            }
        }
        member.setMemberId(id);

        if (members.checkIfExists(member)) {
            System.out.print("Enter new first name: ");
            String newFirstName = scanner.nextLine();
            while (newFirstName.isEmpty()) {
                System.out.print("First name cannot be empty. Please enter a valid first name: ");
                newFirstName = scanner.nextLine();
            }
            member.setFirstName(newFirstName);

            System.out.print("Enter new last name: ");
            String newLastName = scanner.nextLine();
            while (newLastName.isEmpty()) {
                System.out.print("Last name cannot be empty. Please enter a valid last name: ");
                newLastName = scanner.nextLine();
            }
            member.setLastName(newLastName);

            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            while (newEmail.isEmpty()) {
                System.out.print("Email cannot be empty. Please enter a valid email: ");
                newEmail = scanner.nextLine();
            }
            member.setEmail(newEmail);

            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine();
            while (newPhoneNumber.isEmpty()) {
                System.out.print("Phone number cannot be empty. Please enter a valid phone number: ");
                newPhoneNumber = scanner.nextLine();
            }
            member.setPhoneNumber(newPhoneNumber);

            System.out.print("Enter new address: ");
            String newAddress = scanner.nextLine();
            while (newAddress.isEmpty()) {
                System.out.print("Address cannot be empty. Please enter a valid address: ");
                newAddress = scanner.nextLine();
            }
            member.setAddress(newAddress);

            System.out.print("Enter new city: ");
            String newCity = scanner.nextLine();
            while (newCity.isEmpty()) {
                System.out.print("City cannot be empty. Please enter a valid city: ");
                newCity = scanner.nextLine();
            }
            member.setCity(newCity);

            System.out.print("Enter new state: ");
            String newState = scanner.nextLine();
            while (newState.isEmpty()) {
                System.out.print("State cannot be empty. Please enter a valid state: ");
                newState = scanner.nextLine();
            }
            member.setState(newState);

            System.out.print("Enter new zip code: ");
            String newZipCode = scanner.nextLine();
            while (newZipCode.isEmpty()) {
                System.out.print("Zip code cannot be empty. Please enter a valid zip code: ");
                newZipCode = scanner.nextLine();
            }
            member.setZipCode(newZipCode);

            PrinterCommon.clearScreen();
            members.updateMember(member);
        } else {
            PrinterCommon.clearScreen();
            System.out.println("Member with the given ID does not exist.\n");
        }
    }

}
