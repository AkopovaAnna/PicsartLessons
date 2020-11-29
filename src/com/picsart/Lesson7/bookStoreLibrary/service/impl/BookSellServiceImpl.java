package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.BookSell;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.BookSellInterface;
import com.picsart.Lesson7.bookStoreLibrary.utils.DateUtils;

import java.util.Date;


public class BookSellServiceImpl implements BookSellInterface {

    public BookServiceImpl service;
    BookSell[] bookSells = new BookSell[20];


    int currentSell = 0;

    public BookSellServiceImpl(BookServiceImpl service) {
        this.service = service;
    }

    public void addBookSell(BookSell bookSell) {
        bookSell.setDateOfPurchase(new Date());

        if (bookSells.length > currentSell) {
            bookSells[currentSell] = bookSell;
            currentSell++;
        } else {
            System.out.println("extra books not allowed");
        }

    }


    @Override
    public void sell(Integer bookId) {
        for (int i = 0; i < service.bookStore.getCurrentBookCount(); i++) {
            if (bookId.equals(service.bookStore.getBooks()[i].getBookId())) {

                PaperBook pb = (PaperBook) service.bookStore.getBooks()[i];
                if (pb.isSellable()) {
                    int newCount = pb.getNumberOfCopies();
                    if (pb.getNumberOfCopies() == 0) {
                        System.out.println("There are no available book");
                    } else if (pb.getNumberOfCopies() == 1) {
                        int totalCount = service.bookStore.getCurrentBookCount();
                        service.bookStore.setCurrentBookCount(--totalCount);
                    } else {
                        int totalNumb = service.bookStore.getTotalNumber();
                        pb.setNumberOfCopies(--newCount);

                        service.bookStore.setTotalNumber(--totalNumb);
                        service.bookStore.setGrossIncome(service.bookStore.getGrossIncome() + pb.getPrice());

                    }
                    break;

                } else {
                    System.out.println("The book with " + bookId + " not exist");
                }

                BookSell bookSell = new BookSell();
                bookSell.setBookId(bookId);
                addBookSell(bookSell);
            } else {
                System.out.println("not sellable");
            }
        }


    }

    @Override
    public Integer returnBook(int bookSellId, Integer bookId) {
        for (int i = 0; i < currentSell; i++) {
            if (bookSellId == bookSells[i].getBookSellId()) {
                if (DateUtils.getDateOfMonth(bookSells[i].getDateOfPurchase()) > bookSells[i].getDUE_DATE()) {
                    System.out.println("Cannot take book, 14 days left");
                } else {
                    if (bookId.equals(service.bookStore.getBooks()[i].getBookId())) {
                        service.changeBookCounts(service.getBookById(bookId));
                        service.addBook(service.getBookById(bookId));
                    }
                }
            }

        }
        return bookId;
    }

}
