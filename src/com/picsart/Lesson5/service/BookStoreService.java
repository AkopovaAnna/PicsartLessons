package com.picsart.Lesson5.service;

import com.picsart.Lesson5.model.BookRent;
import com.picsart.Lesson5.model.BookSell;
import com.picsart.Lesson5.model.BookStoreLibrary;
import com.picsart.Lesson5.model.book.Book;
import com.picsart.Lesson5.model.book.Ebook;
import com.picsart.Lesson5.model.book.PaperBook;
import com.picsart.Lesson5.model.staff.Staff;

import java.util.Calendar;
import java.util.Date;

public class BookStoreService {

    BookSell[] bookSells = new BookSell[20];
    BookRent[] bookRents = new BookRent[10];
    BookStoreLibrary store = new BookStoreLibrary();

    int currentSell = 0;
    int currentRent = 0;


    public void addBookSell(BookSell bookSell, int sellerID) {
        bookSell.setSellerId(sellerID);
        bookSell.setDateOfPurchase(new Date());

        if (bookSells.length > currentSell) {
            bookSells[currentSell] = bookSell;
            currentSell++;
            bookSell.setBookSellId(currentSell);
        } else {
            System.out.println("extra books not allowed");
        }

    }

    public int sellPaperBook(int sellerId, int bookId) {

        for (int i = 0; i < store.getCurrentBookCount(); i++) {

            if (bookId == store.getBooks()[i].getBookId()) {
                PaperBook pb = (PaperBook) store.getBooks()[i];
                int newCount = pb.getNumberOfCopies();
                if (pb.getNumberOfCopies() == 0) {
                    System.out.println("There are no available book");
                    return -1;
                } else if (pb.getNumberOfCopies() == 1) {
                    int totalCount = store.getCurrentBookCount();
                    store.setCurrentBookCount(--totalCount);
                } else {
                    int totalNumb = store.getTotalNumber();
                    pb.setNumberOfCopies(--newCount);

                    store.setTotalNumber(--totalNumb);
                    store.setGrossIncome(store.getGrossIncome() + pb.getPrice());

                }
                break;

            }
        }

        BookSell bookSell = new BookSell();
        bookSell.setBookId(bookId);
        addBookSell(bookSell, sellerId);
        return bookSell.getBookSellId();

    }

    public void sellEbook(int bookId) {
        for (int i = 0; i < store.getCurrentBookCount(); i++) {

            if (bookId == store.getBooks()[i].getBookId()) {
                Ebook eb = (Ebook) store.getBooks()[i];
                int newCount = eb.getDownloadedCount();

                eb.setDownloadedCount(++newCount);
                System.out.println("downloads count: " + eb.getDownloadedCount());
            }
        }
    }


    public void addBookRent(BookRent bookRent, int clientId) {
        bookRent.setClientId(clientId);
        if (bookRents.length > currentRent) {
            bookRents[currentRent] = bookRent;
            currentRent++;

        } else {
            System.out.println("no extra rent book");
        }
    }


    public int getDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public int addBook(Book book) {
        if (store.getBooks().length > store.getCurrentBookCount()) {
            store.getBooks()[store.getCurrentBookCount()] = book;
            int count = store.getCurrentBookCount();
            int totalCount = store.getTotalNumber();
            store.setCurrentBookCount(++count);
            PaperBook pb = (PaperBook) book;
            store.setTotalNumber(totalCount + pb.getNumberOfCopies());

        }
        return book.getBookId();
    }

    public void addEbook(Book book) {
        if (store.getBooks().length > store.getCurrentBookCount()) {
            store.getBooks()[store.getCurrentBookCount()] = book;
            int count = store.getCurrentBookCount();
            int totalCount = store.getTotalNumber();
            store.setCurrentBookCount(++count);
            store.setTotalNumber(totalCount + 1);

        }
    }


    public void addEmployee(Staff employee) {
        if (store.getCurrentEmployeeCount() < store.getEmployee().length) {
            store.getEmployee()[store.getCurrentEmployeeCount()] = employee;
            int count = store.getCurrentEmployeeCount();
            store.setCurrentEmployeeCount(++count);

        } else {
            System.out.println("invalid provided data");
        }
    }

    public void returnSellBook(int bookSellId, Book book) {

        for (int i = 0; i < currentSell; i++) {
            if (bookSellId == bookSells[i].getBookSellId()) {
                if (getDateOfMonth(bookSells[i].getDateOfPurchase()) > bookSells[i].getDUE_DATE()) {
                    System.out.println("Cannot take book, 14 days left");
                } else {
                    changeBookCounts(book);
                    addBook(book);
                    store.setGrossIncome(store.getGrossIncome() - book.getPrice());
                }
            }
        }
    }

    public void checkOut(int bookId, int clientId) {

        for (int i = 0; i < store.getCurrentBookCount(); i++) {

            if (bookId == store.getBooks()[i].getBookId()) {
                PaperBook pb = (PaperBook) store.getBooks()[i];
                int num = pb.getNumberOfCopies();
                if (pb.getNumberOfCopies() > 0) {
                    BookRent bookRent = new BookRent();
                    bookRent.setBookId(bookId);
                    bookRent.setRentDay(new Date());
                    Date expireDate = addDays(bookRent.getRentDay(), 20);
                    bookRent.setExpirationDate(expireDate); //now + 20
                    addBookRent(bookRent, clientId);
                    pb.setNumberOfCopies(--num);
                } else {
                    System.out.println("all books are in rent");
                    return;
                }
            }
        }


    }

    public void checkIn(Book book, int clientId) {
        for (BookRent br : bookRents) {
            if (clientId == br.getClientId() && book.getBookId() == br.getBookId()) {
                br.setActualReturnedDay(new Date());
                int day1 = getDateOfMonth(br.getExpirationDate());
                int day2 = getDateOfMonth(br.getActualReturnedDay());
                if (day2 > day1) {
                    System.out.println("returned later than expected should pay money");
                    changeBookCounts(book);
                    addBook(book);
                    return;
                }
            } else {
                System.out.println("the book is not exist");
            }
        }
    }

    public void changeBookCounts(Book book) {
        for (Book book1 : store.getBooks()) {
            if (book.getBookId() == book1.getBookId()) {
                PaperBook pb = (PaperBook) book;
                PaperBook pb1 = (PaperBook) book1;
                pb.setNumberOfCopies(pb1.getNumberOfCopies() + 1);
                break;
            }
        }


    }

    public int getAllBooksCount() {
        return store.getTotalNumber();
    }

    public void getAllEmployees() {

        for (int i = 0; i < store.getCurrentEmployeeCount(); i++) {
            System.out.println(store.getEmployee()[i].getfName() + " " + store.getEmployee()[i].getfName());
        }
    }

    public void getAllBooksInfo() {

        for (int i = 0; i < store.getCurrentBookCount(); i++) {
            Book book = store.getBooks()[i];
            System.out.println(book.getTitle() + " " + book.getPrice());
        }
        System.out.println("books count: " + store.getTotalNumber());
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
