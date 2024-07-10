package com.jbt.sysout.menus.loans;

import java.util.Date;
import java.util.Scanner;

import com.jbt.db.containers.Book;
import com.jbt.db.containers.Loan;
import com.jbt.db.drivers.Books;
import com.jbt.db.drivers.Loans;

import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.drivers.PrinterDriverLoan;

public class MenuLoansReturn {

    private static Scanner scanner = new Scanner(System.in);

    public static void returnBook() {

        System.out.println(">>> Returning Book");

        Books books = new Books();
        Book book = new Book();

        Loans loans = new Loans();
        Loan loan = new Loan();

        System.out.print("Enter Loan ID: ");
        String loanID = scanner.nextLine();

        while (loanID.isEmpty() || !loanID.matches("\\d+")) {
            System.out.print("Invalid Loan ID. Please enter a valid ID (digits only): ");
            loanID = scanner.nextLine();
        }
        loan.setLoanId(Integer.parseInt(loanID));

        if (!loans.checkIfExists(loan)){

            PrinterCommon.clearScreen();
            System.out.println("The loan does not exist in the library.");
            return;

        }

        // Get the loan details

        Loan newLoan = loans.getSpecificLoan(loan);
        
        // Check if it has already been returned:
        if (loan.getStatus().equals("returned")) {
            PrinterCommon.clearScreen();
            System.out.println("The book has already been returned.");
            return;
        }

        // Update actual return date 
        newLoan.setActualReturnDate(new Date());

        // Update the loan status to "returned"
        newLoan.setStatus("returned");

        PrinterCommon.printSeparator();

        PrinterDriverLoan.printLoanDetails(newLoan);

        // Calculate if the book is overdue

        
        Date actualReturnDate = newLoan.getActualReturnDate();
        Date returnDueDate = newLoan.getReturnDueDate();
        if (actualReturnDate.after(returnDueDate)) {
            long daysOverdue = (actualReturnDate.getTime() - returnDueDate.getTime()) / (24 * 60 * 60 * 1000);
            System.out.println("The book is " + daysOverdue + " days overdue. Please pay the fine before returning the book.");
        } else {
            System.out.println("The book has been returned on time.");
        }

        // Increase the stock of the book by one.

        book.setIsbn(newLoan.getIsbn());
        books.increaseStockQuantity(book);

        loans.updateLoan(loan);
                    
    }  
}