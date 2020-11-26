package com.picsart.Lesson7.bookStoreLibrary.model;

import java.util.Date;

public class BookRent {

    public static final int EXPIRATION_DUE_DATE = 20;

    private Integer bookId;
    private Date rentDay;
    private Date actualReturnedDay;
    private Date expirationDate;
    private double additionMoney;
    private int clientId;


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
