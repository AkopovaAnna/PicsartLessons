package com.picsart.Lesson7.bookStoreLibrary.model;


import java.util.concurrent.atomic.AtomicInteger;

public abstract class Book {
    private static final AtomicInteger count = new AtomicInteger(0);

    private final Integer bookId;
    private String title;
    private String author;
    private String language;
    private double price;

    public Book() {
        this.bookId = count.incrementAndGet();
    }

    public Integer getBookId() {
        return bookId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
