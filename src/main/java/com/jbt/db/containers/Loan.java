package com.jbt.db.containers;

import java.util.Date;

public class Loan {
    private int loan_id = 0;
    private int member_id = 0;
    private String isbn = "";
    private Date loan_date;
    private Date return_due_date;
    private Date actual_return_date;
    private String status_db = "active";

    public int getLoanId() {
        return loan_id;
    }

    public void setLoanId(int loan_id) {
        if (loan_id >= 0) {
            this.loan_id = loan_id;
        } else {
            throw new IllegalArgumentException(
                "Loan ID must be a non-negative integer."
            );
        }
    }

    public int getMemberId() {
        return member_id;
    }

    public void setMemberId(int member_id) {
        if (member_id >= 0) {
            this.member_id = member_id;
        } else {
            throw new IllegalArgumentException(
                "Member ID must be a non-negative integer."
            );
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn != null && !isbn.isEmpty()) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("ISBN must not be null or empty.");
        }
    }

    public Date getLoanDate() {
        return loan_date;
    }

    public void setLoanDate(Date loan_date) {
        if (loan_date != null) {
            this.loan_date = loan_date;
        } else {
            throw new IllegalArgumentException("Loan date must not be null.");
        }
    }

    public Date getReturnDueDate() {
        return return_due_date;
    }

    public void setReturnDueDate(Date return_due_date) {
        if (return_due_date != null) {
            this.return_due_date = return_due_date;
        } else {
            throw new IllegalArgumentException("Return due date must not be null.");
        }
    }

    public Date getActualReturnDate() {
        return actual_return_date;
    }

    public void setActualReturnDate(Date actual_return_date) {
        this.actual_return_date = actual_return_date;
    }

    public String getStatus() {
        return status_db;
    }

    public void setStatus(String status_db) {
        if (status_db != null && (status_db.equals("active") || status_db.equals("returned"))) {
            this.status_db = status_db;
        } else {
            throw new IllegalArgumentException("Status must be either 'active' or 'returned'.");
        }
    }
}