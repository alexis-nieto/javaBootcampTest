package com.jbt.db.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jbt.db.Config;
import com.jbt.db.containers.Loan;
import com.jbt.sysout.CommonPrinter;
import com.jbt.sysout.printers.LoanPrinter;

public class Loans {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    public void addLoan(Loan loan) {

        String SQL = "INSERT INTO loans (member_id, isbn, loan_date, return_due_date, actual_return_date, status_db) " +
        "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

        ps.setInt(1, loan.getMemberId());
        ps.setString(2, loan.getIsbn());
        ps.setDate(3, new java.sql.Date(loan.getLoanDate().getTime()));
        ps.setDate(4, new java.sql.Date(loan.getReturnDueDate().getTime()));
        ps.setDate(5, loan.getActualReturnDate() != null ? new java.sql.Date(loan.getActualReturnDate().getTime()) : null);
        ps.setString(6, loan.getStatus());

        ps.executeUpdate();

        LoanPrinter.printSuccess("book", loan.getIsbn(), "added");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nA loan with the same ID already exists in the database.\n");
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an unknown error adding the loan to the database.\n");
            e.printStackTrace();
        }
    }

    public void deleteLoan(Loan loan) {
        String SQL = "DELETE FROM loans WHERE loan_id = ?;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

        ps.setInt(1, loan.getLoanId());

        ps.executeUpdate();

        LoanPrinter.printSuccess("Loan ID", String.valueOf(loan.getLoanId()), "deleted");
  
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error deleting the loan from the database.\n");
        }
    }

    public void updateLoan(Loan loan) {

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE loans SET ");
        sb.append("member_id = ?, ");
        sb.append("isbn = ?, ");
        sb.append("loan_date = ?, ");
        sb.append("return_due_date = ?, ");
        sb.append("actual_return_date = ?, ");
        sb.append("status_db = ? ");
        sb.append("WHERE loan_id = ?;");

        System.out.println(loan.getStatus());
        
        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {

        ps.setInt(1, loan.getMemberId());
        ps.setString(2, loan.getIsbn());
        ps.setDate(3, new java.sql.Date(loan.getLoanDate().getTime()));
        ps.setDate(4, new java.sql.Date(loan.getReturnDueDate().getTime()));
        ps.setDate(5, loan.getActualReturnDate() != null ? new java.sql.Date(loan.getActualReturnDate().getTime()) : null);
        ps.setString(6, loan.getStatus());
        ps.setInt(7, loan.getLoanId());

        ps.executeUpdate();

        LoanPrinter.printSuccess("Loan ID", String.valueOf(loan.getLoanId()), "updated");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nThe loan ID already exists in the database, please try with a different one.\n");
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error updating the loan in the database.\n");
            e.printStackTrace();
        }
    }

    public void getLoans(String attribute, String field) {

        StringBuilder sql = new StringBuilder();

        if (attribute.equalsIgnoreCase("all") && field.equalsIgnoreCase("all")) {

            sql.append("SELECT * FROM loans;");

        } else {

            sql.append("SELECT * FROM loans WHERE ");
            sql.append(attribute);
            sql.append(" LIKE LOWER(\"%");
            sql.append(field);
            sql.append("%\");");
        }

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(sql.toString());
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Loan loan = new Loan();

                loan.setLoanId(rs.getInt("loan_id"));
                loan.setMemberId(rs.getInt("member_id"));
                loan.setIsbn(rs.getString("isbn"));
                loan.setLoanDate(rs.getDate("loan_date"));
                loan.setReturnDueDate(rs.getDate("return_due_date"));
                loan.setActualReturnDate(rs.getDate("actual_return_date"));
                loan.setStatus(rs.getString("status_db"));

                CommonPrinter.printSeparator();
                LoanPrinter.printLoanDetails(loan);

            }

            CommonPrinter.printSeparator();

        } catch (Exception e) {
            System.out.println("Task Failed:\nAn error occurred while retrieving the loans from the database.\n");
            e.printStackTrace();
        }
    }

    public void getLoans() {
        getLoans("all", "all");
    }
}
