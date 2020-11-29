package com.picsart.Lesson7.bookStoreLibrary.model;

import java.util.concurrent.atomic.AtomicInteger;

public class BorrowerCard {

    private static final AtomicInteger count = new AtomicInteger(0);

    private final Integer borrowId;
    private String cardNumb;
    private double balance = 0;


    public BorrowerCard() {
        this.borrowId = count.incrementAndGet();
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
