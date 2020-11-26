package com.picsart.Lesson7.bookStoreLibrary.model;


public class BookStoreLibrary {

    private Book[] books;
    private double grossIncome;
    private int currentBookCount;
    private int currentEmployeeCount;
    private int totalNumber;

    public BookStoreLibrary() {
        books = new Book[100];
        grossIncome = 0;
    }


    public int getCurrentEmployeeCount() {
        return currentEmployeeCount;
    }

    public void setCurrentEmployeeCount(int currentEmployeeCount) {
        this.currentEmployeeCount = currentEmployeeCount;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentBookCount() {
        return currentBookCount;
    }

    public void setCurrentBookCount(int currentBookCount) {
        this.currentBookCount = currentBookCount;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }
}
