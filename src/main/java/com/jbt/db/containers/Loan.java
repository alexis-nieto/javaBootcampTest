package com.jbt.db.containers;

import java.util.Date;

public class Loan {
    private int loanId = 0;
    private int bookId = 0;
    private int branchId = 0;
    private int cardNo = 0;
    private Date dateOut;
    private Date dueDate;
    private Date dateIn;

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        if (loanId >= 0) {
            this.loanId = loanId;
        } else {
            throw new IllegalArgumentException(
                "Loan ID must be a non-negative integer."
            );
        }
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        if (bookId >= 0) {
            this.bookId = bookId;
        } else {
            throw new IllegalArgumentException(
                "Book ID must be a non-negative integer."
            );
        }
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        if (branchId >= 0) {
            this.branchId = branchId;
        } else {
            throw new IllegalArgumentException(
                "Branch ID must be a non-negative integer."
            );
        }
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        if (cardNo >= 0) {
            this.cardNo = cardNo;
        } else {
            throw new IllegalArgumentException(
                "Card number must be a non-negative integer."
            );
        }
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        if (dateOut != null) {
            this.dateOut = dateOut;
        } else {
            throw new IllegalArgumentException("Date out must not be null.");
        }
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        if (dueDate != null) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("Due date must not be null.");
        }
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }
}