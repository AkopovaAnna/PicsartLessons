package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookSell;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.BookSellInterface;
import com.picsart.Lesson7.bookStoreLibrary.utils.DateUtils;

import java.util.Date;

public class BookSellServiceImpl implements BookSellInterface {

    BookSell[] bookSells = new BookSell[20];

    BookServiceImpl service = new BookServiceImpl();

    int currentSell = 0;


    public void addBookSell(BookSell bookSell) {
        bookSell.setDateOfPurchase(new Date());

        if (bookSells.length > currentSell) {
            bookSells[currentSell] = bookSell;
            currentSell++;
//            bookSell.setBookSellId(currentSell);
        } else {
            System.out.println("extra books not allowed");
        }

    }


    @Override
    public Integer sell(Integer bookId) {
            for (int i = 0; i < service.bookStore.getCurrentBookCount(); i++) {

                if (bookId.equals(service.bookStore.getBooks()[i].getBookId())) {
                    PaperBook pb = (PaperBook) service.bookStore.getBooks()[i];
                    int newCount = pb.getNumberOfCopies();
                    if (pb.getNumberOfCopies() == 0) {
                        System.out.println("There are no available book");
                        return -1;
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
            }

            BookSell bookSell = new BookSell();
            bookSell.setBookId(bookId);
            addBookSell(bookSell);
            return bookSell.getBookSellId();


    }

    @Override
    public Integer returnBook(int bookSellId, Integer bookId) {
        for (int i = 0; i < currentSell; i++) {
            if (bookSellId == bookSells[i].getBookSellId()) {
                if (DateUtils.getDateOfMonth(bookSells[i].getDateOfPurchase()) > bookSells[i].getDUE_DATE()) {
                    System.out.println("Cannot take book, 14 days left");
                } else {
                    changeBookCounts(getBookById(bookId));
                    service.addBook(getBookById(bookId));
//                    store.setGrossIncome(store.getGrossIncome() - book.getPrice());
                }
            }
        }
        return bookId;
    }


    public void changeBookCounts(Book book) {
        for (Book book1 : service.bookStore.getBooks()) {
            if (book.getBookId().equals(book1.getBookId())) {
                PaperBook pb = (PaperBook) book;
                PaperBook pb1 = (PaperBook) book1;
                pb.setNumberOfCopies(pb1.getNumberOfCopies() + 1);
                break;
            }
        }

    }

    public Book getBookById(Integer bookId) {
        Book[] books = service.bookStore.getBooks();
        for (Book book : books) {
            if (null != bookId && bookId.equals(book.getBookId())) {
                return book;
            }
        }
        return null;
    }
}
