package com.picsart.Lesson7.bookStoreLibrary.model;

import java.util.Date;

public class BookRent {

    public static final int EXPIRATION_DUE_DATE = 20;
    public static final double PER_DAY_FINE = 1000;

    private Integer bookId;
    private Integer borrowId;
    private Date rentDay;
    private Date actualReturnedDay;
    private boolean finePaid;


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Date getRentDay() {
        return rentDay;
    }

    public void setRentDay(Date rentDay) {
        this.rentDay = rentDay;
    }


    public Date getActualReturnedDay() {
        return actualReturnedDay;
    }

    public void setActualReturnedDay(Date actualReturnedDay) {
        this.actualReturnedDay = actualReturnedDay;
    }

    public boolean isFinePaid() {
        return finePaid;
    }

    public void setFinePaid(boolean finePaid) {
        this.finePaid = finePaid;
    }
}
