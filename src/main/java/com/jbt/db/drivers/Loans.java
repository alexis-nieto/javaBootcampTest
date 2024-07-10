package com.jbt.db.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jbt.db.Config;
import com.jbt.db.containers.Loan;
import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.drivers.PrinterDriverLoan;


/**
 * The Loans class provides methods for managing loans in a database.
 * It includes methods for adding, deleting, updating, and retrieving loans.
 * The class uses JDBC to connect to the database and execute SQL queries.
 * It also includes utility methods for checking if a loan exists in the database.
 */
public class Loans {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    /**
         * Adds a new loan to the database.
         *
         * @param loan The Loan object containing the loan details to be added.
         * @throws SQLIntegrityConstraintViolationException if a loan with the same ID already exists in the database.
         * @throws SQLException if there is an unknown error adding the loan to the database.
         */
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

        PrinterDriverLoan.printSuccess("book", loan.getIsbn(), "added");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nA loan with the same ID already exists in the database.\n");
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an unknown error adding the loan to the database.\n");
            e.printStackTrace();
        }
    }

    /**
         * Deletes a loan from the database based on the provided Loan object.
         * 
         * @param loan The Loan object containing the loan_id of the loan to be deleted.
         * @throws SQLException if there is an error deleting the loan from the database.
         */
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

        PrinterDriverLoan.printSuccess("Loan ID", String.valueOf(loan.getLoanId()), "deleted");
  
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error deleting the loan from the database.\n");
        }
    }

    /**
         * Updates an existing loan in the database.
         *
         * @param loan The loan object containing the updated loan details.
         * @throws SQLIntegrityConstraintViolationException if the loan ID already exists in the database.
         * @throws SQLException if there is an error updating the loan in the database.
         */
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

        //System.out.println(loan.getStatus());
        
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

        PrinterDriverLoan.printSuccess("Loan ID", String.valueOf(loan.getLoanId()), "updated");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nThe loan ID already exists in the database, please try with a different one.\n");
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error updating the loan in the database.\n");
            e.printStackTrace();
        }
    }

    /**
         * Retrieves loans from the database based on the specified attribute and field.
         * If both attribute and field are "all", retrieves all loans.
         * Otherwise, retrieves loans where the specified attribute matches the given field (case-insensitive).
         *
         * @param attribute The attribute to filter loans by (e.g., "member_id", "isbn", "status_db")
         * @param field The value to match against the specified attribute
         */
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

                PrinterCommon.printSeparator();
                PrinterDriverLoan.printLoanDetails(loan);

            }

            PrinterCommon.printSeparator();

        } catch (Exception e) {
            System.out.println("Task Failed:\nAn error occurred while retrieving the loans from the database.\n");
            e.printStackTrace();
        }
    }

    /**
         * Retrieves a specific loan from the database based on the provided Loan object.
         *
         * @param loan The Loan object containing the loan ID to retrieve.
         * @return The Loan object with the retrieved loan details, or null if an error occurs.
         */
    public Loan getSpecificLoan(Loan loan) {

        String SQL = "SELECT * FROM loans WHERE loan_id = ?;";
        //System.out.println(loan.getLoanId());

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

            ps.setInt(1, loan.getLoanId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                loan.setLoanId(rs.getInt("loan_id"));
                loan.setMemberId(rs.getInt("member_id"));
                loan.setIsbn(rs.getString("isbn"));
                loan.setLoanDate(rs.getDate("loan_date"));
                loan.setReturnDueDate(rs.getDate("return_due_date"));
                loan.setActualReturnDate(rs.getDate("actual_return_date"));
                loan.setStatus(rs.getString("status_db"));

            }

            return loan;

        } catch (Exception e) {
            System.out.println("Task Failed:\nAn error occurred while retrieving the loans from the database.\n");
            e.printStackTrace();
            return null;
        }
    }

    /**
         * Retrieves all loans from the database.
         */
    public void getLoans() {
        getLoans("all", "all");
    }

    /**
         * Checks if a loan exists in the database.
         *
         * @param loan The Loan object containing the loan ID to check.
         * @return true if the loan exists in the database, false otherwise or if an error occurs.
         */
    public boolean checkIfExists(Loan loan) {
        String SQL = "SELECT COUNT(*) FROM loans WHERE loan_id = ?;";
        //System.out.println(SQL);

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setInt(1, loan.getLoanId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error checking if the loan exists in the database.");
            e.printStackTrace();
            return false;
        }
    }


}
