package com.picsart.Lesson5.model;

import java.util.Date;

public class BookRent {

    private int bookId;
    private Date rentDay;
    private Date expirationDate;
    private Date actualReturnedDay;
    private double additionMoney;
    private int clientId;

    public BookRent() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getRentDay() {
        return rentDay;
    }

    public void setRentDay(Date rentDay) {
        this.rentDay = rentDay;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getActualReturnedDay() {
        return actualReturnedDay;
    }

    public void setActualReturnedDay(Date actualReturnedDay) {
        this.actualReturnedDay = actualReturnedDay;
    }

    public double getAdditionMoney() {
        return additionMoney;
    }

    public void setAdditionMoney(double additionMoney) {
        this.additionMoney = additionMoney;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

}
