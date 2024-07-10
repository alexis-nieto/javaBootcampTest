package com.jbt.sysout.menus.members;

import java.util.Scanner;

import com.jbt.db.containers.Member;
import com.jbt.db.drivers.Members;
import com.jbt.sysout.PrinterCommon;

public class MenuMemberDelete {

    public static Scanner scanner = new Scanner(System.in);


    public static void deleteMember() {

        PrinterCommon.clearScreen();

        Members members = new Members();
        Member member = new Member();
        String memberID = null;

        System.out.print("Enter Member ID to delete: ");

        while (true) {
            memberID = scanner.nextLine();
            if (memberID.matches("\\d+")) {
                break;
            }
            System.out.print("Invalid input. Please enter a valid number: ");
        }
        
        member.setMemberId(Integer.parseInt(memberID));

        PrinterCommon.clearScreen();
        members.deleteMember(member);

    }

}
