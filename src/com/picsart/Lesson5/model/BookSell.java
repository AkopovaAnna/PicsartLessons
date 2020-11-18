package com.picsart.Lesson5.model;

import java.util.Date;

public class BookSell {

    private int bookSellId;
    private int sellerId;
    private int bookId;
    private Date dateOfPurchase;
    private final int DUE_DATE = 14;


    public int getBookSellId() {
        return bookSellId;
    }

    public void setBookSellId(int bookSellId) {
        this.bookSellId = bookSellId;
    }

    public int getDUE_DATE() {
        return DUE_DATE;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}
