package com.picsart.Lesson7.bookStoreLibrary.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class BookSell {

    public static final int DUE_DATE = 14;
    private static final AtomicInteger count = new AtomicInteger(0);

    private final int bookSellId;
    private int bookId;
    private Date dateOfPurchase;


    public BookSell() {
        this.bookSellId = count.incrementAndGet();
    }

    public int getBookSellId() {
        return bookSellId;
    }

    public int getDUE_DATE() {
        return DUE_DATE;
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
