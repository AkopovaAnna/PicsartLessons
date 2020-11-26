package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookRent;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.BookRentService;

import java.util.Date;

import static com.picsart.Lesson7.bookStoreLibrary.utils.DateUtils.addDays;
import static com.picsart.Lesson7.bookStoreLibrary.utils.DateUtils.getDateOfMonth;

public class BookRentServiceImpl implements BookRentService {

    BookStoreLibrary store = new BookStoreLibrary();
    BookRent[] bookRents = new BookRent[10];
    BookServiceImpl service = new BookServiceImpl();
    int currentRent = 0;

    public void addBookRent(BookRent bookRent, int clientId) {
        bookRent.setClientId(clientId);
        if (bookRents.length > currentRent) {
            bookRents[currentRent] = bookRent;
            currentRent++;

        } else {
            System.out.println("no extra rent book");
        }
    }

    @Override
    public void checkIn(Integer bookId, int clientId) {
        for (BookRent br : bookRents) {
            if (clientId == br.getClientId() && bookId == br.getBookId()) {
                br.setActualReturnedDay(new Date());
                int day1 = getDateOfMonth(br.getExpirationDate());
                int day2 = getDateOfMonth(br.getActualReturnedDay());
                if (day2 > day1) {
                    System.out.println("returned later than expected should pay money");
                    changeBookCounts(service.getBookById(bookId));
                    service.addBook(service.getBookById(bookId));
                    return;
                }
            } else {
                System.out.println("the book is not exist");
            }
        }
    }

    @Override
    public void checkOut(Integer bookId, int clientId) {
        for (int i = 0; i < store.getCurrentBookCount(); i++) {

            if (bookId.equals(store.getBooks()[i].getBookId())) {
                PaperBook pb = (PaperBook) store.getBooks()[i];
                int num = pb.getNumberOfCopies();
                if (pb.getNumberOfCopies() > 0) {
                    BookRent bookRent = new BookRent();
                    bookRent.setBookId(bookId);
                    bookRent.setRentDay(new Date());
                    Date expireDate = addDays(bookRent.getRentDay(), BookRent.EXPIRATION_DUE_DATE);
                    bookRent.setExpirationDate(expireDate);
                    addBookRent(bookRent, clientId);
                    pb.setNumberOfCopies(--num);
                } else {
                    System.out.println("all books are in rent");
                    return;
                }
            }
        }
    }


    public void changeBookCounts(Book book) {
        for (Book book1 : store.getBooks()) {
            if (book.getBookId().equals(book1.getBookId())) {
                PaperBook pb = (PaperBook) book;
                PaperBook pb1 = (PaperBook) book1;
                pb.setNumberOfCopies(pb1.getNumberOfCopies() + 1);
                break;
            }
        }

    }


}
