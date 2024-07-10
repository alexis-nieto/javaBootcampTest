package com.jbt.sysout.menus.loans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.jbt.db.containers.Book;
import com.jbt.db.containers.Loan;
import com.jbt.db.containers.Member;
import com.jbt.db.drivers.Books;
import com.jbt.db.drivers.Loans;
import com.jbt.db.drivers.Members;

import com.jbt.sysout.PrinterCommon;

public class MenuLoansBorrow {

    private static Scanner scanner = new Scanner(System.in);

    private static int daysToBorrow = 10;

    public static void borrowBook() {

        System.out.println(">>> Borrowing Book");

        Books books = new Books();
        Book book = new Book();
        
        Members members = new Members();
        Member member = new Member();

        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();

        while (isbn.isEmpty() || !isbn.matches("\\d{10,13}")) {
            System.out.print("Invalid ISBN. Please enter a valid ISBN (10-13 digits): ");
            isbn = scanner.nextLine();
        }
        book.setIsbn(isbn);

        // First check if the book exists in the library.
        if (!books.checkIfExists(book)) {

            PrinterCommon.clearScreen();
            System.out.println("The book does not exist in the library.");
            return;

        }

        // Check if there is enough stock for the book.
        if ( !(books.getStockQuantity(book) > 0) ) {

            PrinterCommon.clearScreen();
            System.out.println("Not enough stock to borrow for this ISBN");
            return;

        }

        // Get memberID from user input and check if member exists.

        System.out.print("Enter member ID to borrow the book: ");
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

        System.out.println("Proceeding to borrow the book...");

        // Create a new loan and add it to the database

        Loans loans = new Loans();
        Loan loan = new Loan();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        loan.setMemberId(member.getMemberId());
        loan.setIsbn(book.getIsbn());
        loan.setStatus("active");

        // Add 10 days because it can borrowed only that long.
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, daysToBorrow);
        Date returnDate = calendar.getTime();

        try {
            loan.setLoanDate(new Date());
            loan.setReturnDueDate( returnDate );

        } catch (Exception e) {
            e.printStackTrace();
        }

        PrinterCommon.clearScreen();
        loans.addLoan(loan);
        books.decreaseStockQuantity(book);

        

    }

}
