package com.picsart.Lesson5.model;

import com.picsart.Lesson5.model.book.Book;
import com.picsart.Lesson5.model.staff.Staff;

public class BookStoreLibrary {

    private Book[] books;
    private Staff[] employee;
    private double grossIncome;
    private int currentBookCount;
    private int currentEmployeeCount;
    private int totalNumber;

    public BookStoreLibrary() {
        books = new Book[100];
        employee = new Staff[10];
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

    public Staff[] getEmployee() {
        return employee;
    }

    public void setEmployee(Staff[] employee) {
        this.employee = employee;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }
}
