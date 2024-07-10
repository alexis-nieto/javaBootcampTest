package com.jbt.sysout.menus.members;

import java.util.Date;
import java.util.Scanner;

import com.jbt.db.containers.Member;
import com.jbt.db.drivers.Members;
import com.jbt.sysout.PrinterCommon;

public class MenuMemberAdd {

    private static Scanner scanner = new Scanner(System.in);

    public static void addNewMember() {

        System.out.println(">>> Adding new Member");

        Members members = new Members();
        Member member = new Member();
        
        // Prompt user for member details

        System.out.print("Email: ");
        String email = scanner.nextLine();
        while (email.isEmpty()) {
            System.out.print("Email cannot be empty. Please enter a valid email: ");
            email = scanner.nextLine();
        }
        member.setEmail(email);
        while (members.checkIfExists(member)) {
            System.out.print("Email already exists. Please enter a different email: ");
            email = scanner.nextLine();
            member.setEmail(email);
        }

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        while (firstName.isEmpty()) {
            System.out.print("First Name cannot be empty. Please enter a valid first name: ");
            firstName = scanner.nextLine();
        }
        member.setFirstName(firstName);

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        while (lastName.isEmpty()) {
            System.out.print("Last Name cannot be empty. Please enter a valid last name: ");
            lastName = scanner.nextLine();
        }
        member.setLastName(lastName);

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        while (phoneNumber.isEmpty()) {
            System.out.print("Phone Number cannot be empty. Please enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
        }
        member.setPhoneNumber(phoneNumber);
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        while (address.isEmpty()) {
            System.out.print("Address cannot be empty. Please enter a valid address: ");
            address = scanner.nextLine();
        }
        member.setAddress(address);

        System.out.print("City: ");
        String city = scanner.nextLine();
        while (city.isEmpty()) {
            System.out.print("City cannot be empty. Please enter a valid city: ");
            city = scanner.nextLine();
        }
        member.setCity(city);

        System.out.print("State: ");
        String state = scanner.nextLine();
        while (state.isEmpty()) {
            System.out.print("State cannot be empty. Please enter a valid state: ");
            state = scanner.nextLine();
        }
        member.setState(state);

        System.out.print("Zip Code: ");
        String zipCode = scanner.nextLine();
        while (zipCode.isEmpty()) {
            System.out.print("Zip Code cannot be empty. Please enter a valid zip code: ");
            zipCode = scanner.nextLine();
        }
        member.setZipCode(zipCode);

        member.setMembershipStartDate(new Date());

        PrinterCommon.clearScreen();

        members.addMember(member);

    }
}
