package com.jbt.sysout.menus.loans;

import java.util.Scanner;

import com.jbt.db.containers.Member;
import com.jbt.db.drivers.Loans;
import com.jbt.db.drivers.Members;
import com.jbt.sysout.PrinterCommon;

public class MenuLoansHistory {

    private static Scanner scanner = new Scanner(System.in);

    public static void viewLoanHistory(){

        Members members = new Members();
        Member member = new Member();

        // Get member id from user
        
        System.out.print("Enter member ID to check: ");
        String memberID = scanner.nextLine();

        while (memberID.isEmpty() || !memberID.matches("\\d+")) {
            System.out.print("Invalid member ID. Please enter a valid member ID: ");
            memberID = scanner.nextLine();
        }

        member.setMemberId( Integer.parseInt(memberID) );

        if (!members.checkIfExists(member)){

            PrinterCommon.clearScreen();
            System.out.println("The member does not exist in the library.");
            return;

        }

        // Get the loan history for the member

        Loans loans = new Loans();

        loans.getLoans("member_id", memberID);

        // Prompt user to go back to main menu
        System.out.println("Press Enter to go back to the main menu...");
        scanner.nextLine();
        PrinterCommon.clearScreen();

    }

}
