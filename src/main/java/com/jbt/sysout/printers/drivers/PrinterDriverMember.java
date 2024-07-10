package com.jbt.sysout.printers.drivers;

import com.jbt.db.containers.Member;

public class PrinterDriverMember {

    public static void printMemberDetails(Member member) {
        System.out.println("Member ID: " + member.getMemberId());
        System.out.println("First Name: " + member.getFirstName());
        System.out.println("Last Name: " + member.getLastName());
        System.out.println("Phone Number: " + member.getPhoneNumber());
        System.out.println("Email: " + member.getEmail());
        System.out.println("Address: " + member.getAddress());
        System.out.println("City: " + member.getCity());
        System.out.println("State: " + member.getState());
        System.out.println("Zip Code: " + member.getZipCode());
        System.out.println("Membership Start Date: " + member.getMembershipStartDate());
    }

    public static void printSuccess(String attribute, String field, String event){

        StringBuilder sb = new StringBuilder();
        sb.append("Member with ");
        sb.append(attribute);
        sb.append(": '");
        sb.append(field);
        sb.append("' was ");
        sb.append(event);
        sb.append(" successfully.");
        System.out.println(sb.toString());
    }

}
