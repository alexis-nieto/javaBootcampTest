package com.jbt.db.containers;

import java.util.Date;

/**
 * Represents a loan in the library system.
 * A loan is associated with a member and a book (identified by ISBN).
 * It contains information about the loan date, return due date, actual return date, and status.
 * The class provides getters and setters for all attributes, with validation checks to ensure data integrity.
 */
public class Loan {
    private int loan_id = 0;
    private int member_id = 0;
    private String isbn = "";
    private Date loan_date;
    private Date return_due_date;
    private Date actual_return_date;
    private String status_db = "active";

    /**
         * Retrieves the loan ID of this loan.
         *
         * @return The loan ID as a non-negative integer.
         */
    public int getLoanId() {
        return loan_id;
    }

    /**
         * Sets the loan ID for this loan.
         * The loan ID must be a non-negative integer.
         *
         * @param loan_id the loan ID to set
         * @throws IllegalArgumentException if the loan ID is negative
         */
    public void setLoanId(int loan_id) {
        if (loan_id >= 0) {
            this.loan_id = loan_id;
        } else {
            throw new IllegalArgumentException(
                "Loan ID must be a non-negative integer."
            );
        }
    }

    /**
         * Retrieves the member ID associated with this loan.
         *
         * @return The member ID as a non-negative integer.
         */
    public int getMemberId() {
        return member_id;
    }

    /**
         * Sets the member ID associated with this loan.
         *
         * @param member_id The member ID as a non-negative integer.
         * @throws IllegalArgumentException If the provided member ID is negative.
         */
    public void setMemberId(int member_id) {
        if (member_id >= 0) {
            this.member_id = member_id;
        } else {
            throw new IllegalArgumentException(
                "Member ID must be a non-negative integer."
            );
        }
    }

    /**
         * Retrieves the ISBN associated with this loan.
         *
         * @return The ISBN as a string.
         */
    public String getIsbn() {
        return isbn;
    }

    /**
             * Sets the ISBN for this loan.
             *
             * @param isbn The ISBN as a non-empty string.
             * @throws IllegalArgumentException If the provided ISBN is null or empty.
             */
    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.isEmpty()) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("ISBN must not be null or empty.");
        }
    }

    /**
         * Retrieves the loan date for this loan.
         *
         * @return The loan date as a Date object.
         */
    public Date getLoanDate() {
        return loan_date;
    }

    /**
         * Sets the loan date for this loan.
         *
         * @param loan_date The loan date as a Date object.
         * @throws IllegalArgumentException If the provided loan date is null.
         */
    public void setLoanDate(Date loan_date) {
        if (loan_date != null) {
            this.loan_date = loan_date;
        } else {
            throw new IllegalArgumentException("Loan date must not be null.");
        }
    }

    /**
             * Retrieves the return due date for this loan.
             *
             * @return The return due date as a Date object.
             */
    public Date getReturnDueDate() {
        return return_due_date;
    }

    /**
         * Sets the return due date for this loan.
         *
         * @param return_due_date The return due date as a Date object.
         * @throws IllegalArgumentException If the provided return due date is null.
         */
    public void setReturnDueDate(Date return_due_date) {
        if (return_due_date != null) {
            this.return_due_date = return_due_date;
        } else {
            throw new IllegalArgumentException("Return due date must not be null.");
        }
    }

    /**
             * Retrieves the actual return date for this loan.
             *
             * @return The actual return date as a Date object.
             */
    public Date getActualReturnDate() {
        return actual_return_date;
    }

    /**
             * Sets the actual return date for this loan.
             *
             * @param actual_return_date The actual return date as a Date object.
             * @throws IllegalArgumentException If the provided return due date is null.
             */
    public void setActualReturnDate(Date actual_return_date) {
        
        if (return_due_date != null) {
            this.actual_return_date = actual_return_date;
        } else {
            throw new IllegalArgumentException("Return due date must not be null.");
        }
    }

    /**
         * Retrieves the status of this loan.
         *
         * @return The status as a String, either "active" or "returned".
         */
    public String getStatus() {
        return status_db;
    }

    /**
         * Sets the status for this loan.
         *
         * @param status_db The status as a String, either "active" or "returned".
         * @throws IllegalArgumentException If the provided status is null or not one of "active" or "returned".
         */
    public void setStatus(String status_db) {
        if (status_db != null && (status_db.equals("active") || status_db.equals("returned"))) {
            this.status_db = status_db;
        } else {
            throw new IllegalArgumentException("Status must be either 'active' or 'returned'.");
        }
    }
}