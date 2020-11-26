package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.BookService;

public class BookServiceImpl implements BookService {

    BookStoreLibrary bookStore = new BookStoreLibrary();

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
        Book[] books = bookStore.getBooks();
        for (Book book : books) {
            if (null != bookId && bookId.equals(book.getBookId())){
                return book;
            }
        }
        return null;
    }

}
