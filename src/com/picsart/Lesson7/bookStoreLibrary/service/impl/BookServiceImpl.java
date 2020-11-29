package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.BookService;

public class BookServiceImpl implements BookService {

    public BookStoreLibrary bookStore;

    public BookServiceImpl(BookStoreLibrary bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public Integer addBook(Book book) {
        if (bookStore.getBooks().length > bookStore.getCurrentBookCount()) {
            bookStore.getBooks()[bookStore.getCurrentBookCount()] = book;
            int count = bookStore.getCurrentBookCount();
            int totalCount = bookStore.getTotalNumber();
            bookStore.setCurrentBookCount(++count);
            PaperBook pb = (PaperBook) book;
            bookStore.setTotalNumber(totalCount + pb.getNumberOfCopies());

        }
        return book.getBookId();
    }

    public Book getBookById(Integer bookId) {
        for (int i = 0; i < bookStore.getCurrentBookCount(); i++) {
            if (bookId.equals(bookStore.getBooks()[i].getBookId())) {
                return bookStore.getBooks()[i];
            }
        }
        return null;
    }

    public void changeBookCounts(Book book) {
        for (int i = 0; i < bookStore.getCurrentBookCount(); i++) {
            if (book.getBookId().equals(bookStore.getBooks()[i].getBookId())) {
                PaperBook pb = (PaperBook) book;
                PaperBook pb1 = (PaperBook) bookStore.getBooks()[i];
                pb.setNumberOfCopies(pb1.getNumberOfCopies() + 1);
                break;
            }
        }

    }

    public void printBookInfoById(Integer id) {
        PaperBook book = (PaperBook) getBookById(id);
        if (null != book) {
            System.out.println(book.toString());
        } else {
            System.out.println("no book to print");
        }

    }

}
