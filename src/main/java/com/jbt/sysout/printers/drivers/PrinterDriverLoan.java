package com.jbt.sysout.printers.drivers;

import com.jbt.db.containers.Loan;

public class PrinterDriverLoan {

    public static void printLoanDetails(Loan loan) {
        System.out.println("Loan ID: " + loan.getLoanId());
        System.out.println("Member ID: " + loan.getMemberId());
        System.out.println("ISBN: " + loan.getIsbn());
        System.out.println("Loan Date: " + loan.getLoanDate());
        System.out.println("Return Due Date: " + loan.getReturnDueDate());
        System.out.println("Actual Return Date: " + loan.getActualReturnDate());
        System.out.println("Status: " + loan.getStatus());
    }

    public static void printSuccess(String attribute, String field, String event){

        StringBuilder sb = new StringBuilder();
        sb.append("Loan with ");
        sb.append(attribute);
        sb.append(": '");
        sb.append(field);
        sb.append("' was ");
        sb.append(event);
        sb.append(" successfully.");
        System.out.println(sb.toString());
    }

}
