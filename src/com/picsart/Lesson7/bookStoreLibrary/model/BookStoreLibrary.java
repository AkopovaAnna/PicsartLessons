package com.picsart.Lesson7.bookStoreLibrary.model;


public class BookStoreLibrary {

    private Book[] books;
    private BorrowerCard[] borrowers;
    private double grossIncome;
    private int currentBookCount;
    private int currentBorrowerCount;
    private int totalNumber;

    public BookStoreLibrary() {
        books = new Book[100];
        borrowers = new BorrowerCard[20];
        grossIncome = 0;
    }


    public BorrowerCard[] getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(BorrowerCard[] borrowers) {
        this.borrowers = borrowers;
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

    public int getCurrentBorrowerCount() {
        return currentBorrowerCount;
    }

    public void setCurrentBorrowerCount(int currentBorrowerCount) {
        this.currentBorrowerCount = currentBorrowerCount;
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
