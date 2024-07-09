package com.jbt.sysout.printers;

import com.jbt.db.containers.Loan;

public class LoanPrinter {

    public static void printLoanDetails(Loan loan) {
        System.out.println("Loan ID: " + loan.getLoanId());
        System.out.println("Book ID: " + loan.getBookId());
        System.out.println("Member ID: " + loan.getMemberId());
        System.out.println("Loan Date: " + loan.getLoanDate());
        System.out.println("Due Date: " + loan.getDueDate());
        System.out.println("Return Date: " + loan.getReturnDate());
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
