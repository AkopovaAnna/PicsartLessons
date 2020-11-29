package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.BorrowerCard;

public class BorrowerService {

    public BookStoreLibrary bookStore;

    public BorrowerService(BookStoreLibrary bookStore) {
        this.bookStore = bookStore;
    }

    public void addBorrower(BorrowerCard borrower) {
        if (bookStore.getBorrowers().length > bookStore.getCurrentBorrowerCount()) {
            bookStore.getBorrowers()[bookStore.getCurrentBorrowerCount()] = borrower;
            int count = bookStore.getCurrentBorrowerCount();
            bookStore.setCurrentBorrowerCount(++count);
        }
    }

    public BorrowerCard getBorrowerById(Integer borrowId) {
        BorrowerCard[] borrowers = bookStore.getBorrowers();
        for (BorrowerCard borrower : borrowers) {
            if (borrowId.equals(borrower.getBorrowId())) {
                return borrower;
            }
        }

        return null;
    }
}
