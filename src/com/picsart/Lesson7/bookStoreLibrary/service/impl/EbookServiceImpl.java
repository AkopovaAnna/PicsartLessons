package com.picsart.Lesson7.bookStoreLibrary.service.impl;


import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.Ebook;
import com.picsart.Lesson7.bookStoreLibrary.service.EbookService;

public class EbookServiceImpl implements EbookService {

    public BookStoreLibrary store;

    public EbookServiceImpl(BookStoreLibrary store) {
        this.store = store;
    }

    @Override
    public void preview(Integer bookId) {
        for (int i = 0; i < store.getCurrentBookCount(); i++) {

            if (bookId.equals(store.getBooks()[i].getBookId())) {

                System.out.println("you can preview the content of the book " + store.getBooks()[i].getTitle());
            }
        }

    }

    @Override
    public void download(Integer bookId) {
        for (int i = 0; i < store.getCurrentBookCount(); i++) {

            if (bookId.equals(store.getBooks()[i].getBookId())) {
                Ebook eb = (Ebook) store.getBooks()[i];
                int newCount = eb.getDownloadedCount();

                eb.setDownloadedCount(++newCount);

                System.out.println("downloads count: " + eb.getDownloadedCount());
            }
        }
    }


    @Override
    public Integer addBook(Book book) {
        if (store.getBooks().length > store.getCurrentBookCount()) {
            store.getBooks()[store.getCurrentBookCount()] = book;
            int count = store.getCurrentBookCount();
            int totalCount = store.getTotalNumber();
            store.setCurrentBookCount(++count);
            store.setTotalNumber(totalCount + 1);

        }
        return book.getBookId();
    }

    public Book getBookById(Integer bookId) {
        for (int i = 0; i < store.getCurrentBookCount(); i++) {
            if (bookId.equals(store.getBooks()[i].getBookId())) {
                return store.getBooks()[i];
            }
        }
        return null;
    }

    public void printEBookInfoById(Integer id) {
        Ebook book = (Ebook) getBookById(id);
        if (null != book) {
            System.out.println(book.toString());
        } else {
            System.out.println("no book to print");
        }

    }
}
