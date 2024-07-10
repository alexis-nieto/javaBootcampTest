package com.jbt.sysout.menus.members;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jbt.db.drivers.Members;
import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.menus.PrinterMenuMembers;

public class MenuMemberSearch {

    public static Scanner scanner = new Scanner(System.in);

    public static void searchMember() {

        PrinterMenuMembers.printMemberSearch();
        Members members = new Members();
        
        boolean validChoice = false;
        while (!validChoice) {
            try {
                String choice = scanner.nextLine();
                
                switch (choice) {
                    case "1":
                        // Perform search by Member ID
                        int memberId = 0;
                        while (memberId <= 0) {
                            try {
                                System.out.println("Enter Member ID:");
                                memberId = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid member ID.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }
                        validChoice = true;
                        members.getMembers("member_id", String.valueOf(memberId));
                        break;
                    case "2":
                        // Perform search by First Name
                        String firstName = "";
                        while (firstName.isEmpty()) {
                            System.out.println("Enter First Name:");
                            firstName = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("first_name", firstName);
                        break;
                    case "3":
                        // Perform search by Last Name
                        String lastName = "";
                        while (lastName.isEmpty()) {
                            System.out.println("Enter Last Name:");
                            lastName = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("last_name", lastName);
                        break;
                    case "4":
                        // Perform search by Email
                        String email = "";
                        while (email.isEmpty()) {
                            System.out.println("Enter Email:");
                            email = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("email", email);
                        break;
                    case "5":
                        // Perform search by Phone Number
                        String phoneNumber = "";
                        while (phoneNumber.isEmpty()) {
                            System.out.println("Enter Phone Number:");
                            phoneNumber = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("phone_number", phoneNumber);
                        break;
                    case "6":
                        // Perform search by Address
                        String address = "";
                        while (address.isEmpty()) {
                            System.out.println("Enter Address:");
                            address = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("address_db", address);
                        break;
                    case "7":
                        // Perform search by City
                        String city = "";
                        while (city.isEmpty()) {
                            System.out.println("Enter City:");
                            city = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("city", city);
                        break;
                    case "8":
                        // Perform search by State
                        String state = "";
                        while (state.isEmpty()) {
                            System.out.println("Enter State:");
                            state = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("state_db", state);
                        break;
                    case "9":
                        // Perform search by Zip Code
                        String zipCode = "";
                        while (zipCode.isEmpty()) {
                            System.out.println("Enter Zip Code:");
                            zipCode = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("zip_code", zipCode);
                        break;
                    case "10":
                        // Perform search by Membership Start Date
                        String membershipStartDate = "";
                        while (membershipStartDate.isEmpty()) {
                            System.out.println("Enter Membership Start Date (yyyy-MM-dd):");
                            membershipStartDate = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        members.getMembers("membership_start_date", membershipStartDate);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                PrinterCommon.clearScreen();
                System.out.println("Invalid option, please try again.\n");
            }
        }
    }        
}
