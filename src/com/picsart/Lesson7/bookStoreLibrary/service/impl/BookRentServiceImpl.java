package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.BookRent;
import com.picsart.Lesson7.bookStoreLibrary.model.BorrowerCard;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.BookRentService;
import com.picsart.Lesson7.bookStoreLibrary.utils.DateUtils;
import com.picsart.Lesson7.bookStoreLibrary.exception.NegativeBalanceException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.picsart.Lesson7.bookStoreLibrary.model.BookRent.EXPIRATION_DUE_DATE;
import static com.picsart.Lesson7.bookStoreLibrary.model.BookRent.PER_DAY_FINE;
import static com.picsart.Lesson7.bookStoreLibrary.utils.DateUtils.getDateOfMonth;

public class BookRentServiceImpl implements BookRentService {

    BookRent[] bookRents = new BookRent[10];
    BookServiceImpl service;
    BorrowerService borrowerService;
    int currentRent = 0;

    public BookRentServiceImpl(BookServiceImpl service, BorrowerService borrowerService) {
        this.service = service;
        this.borrowerService = borrowerService;

    }

    public void addBookRent(BookRent bookRent, int borrowerId) {
        bookRent.setBorrowId(borrowerId);
        if (bookRents.length > currentRent) {
            bookRents[currentRent] = bookRent;
            currentRent++;

        } else {
            System.out.println("no extra rent book");
        }
    }

    @Override
    public void checkIn(Integer bookId, Integer borrowerId) {

        if (currentRent > 0) {
            for (int i = 0; i < currentRent; i++) {
                if (borrowerId.equals(bookRents[i].getBorrowId()) && bookId == bookRents[i].getBookId()) {
                    bookRents[i].setActualReturnedDay(new Date());
                    Date expiredDate = DateUtils.addDays(bookRents[i].getRentDay(), EXPIRATION_DUE_DATE);
                    int day1 = getDateOfMonth(expiredDate);
                    int day2 = getDateOfMonth(bookRents[i].getActualReturnedDay());
                    if (day2 > day1) {
                        System.out.println("returned later than expected should pay money");
                        BorrowerCard borrower = this.borrowerService.getBorrowerById(borrowerId);
                        borrower.setBalance(borrower.getBalance() - calculateFine(bookRents[i].getActualReturnedDay(), expiredDate, PER_DAY_FINE));
                        service.changeBookCounts(service.getBookById(bookId));


                        service.addBook(service.getBookById(bookId));

                    }
                } else {
                    System.out.println("the book is not exist");
                }
            }
        } else {
            System.out.println("no any book for rent");
        }
    }

    @Override
    public void checkOut(Integer bookId, Integer borrowerId) {
        for (int i = 0; i < service.bookStore.getCurrentBookCount(); i++) {

            if (bookId.equals(service.bookStore.getBooks()[i].getBookId())) {
                PaperBook pb = (PaperBook) service.bookStore.getBooks()[i];
                int num = pb.getNumberOfCopies();
                if (pb.getNumberOfCopies() > 0) {
                    BorrowerCard borrower = this.borrowerService.getBorrowerById(borrowerId);
                    if (borrower.getBalance() >= 0) {
                        pb.setNumberOfCopies(--num);
                    } else {
                        throw new NegativeBalanceException("not enough balance to rent book");
                    }

                } else {
                    System.out.println("all books are in rent");
                    return;
                }
            }
        }
        BookRent bookRent = new BookRent();
        bookRent.setBookId(bookId);
        bookRent.setRentDay(new Date());
        addBookRent(bookRent, borrowerId);
    }


    public double calculateFine(Date returnDate, Date dueDate, double fine) {

        if (returnDate.after(dueDate)) {
            long diffInMillis = Math.abs(dueDate.getTime() - returnDate.getTime());
            long difference = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            difference = Math.abs(difference);
            return fine * difference;
        } else {
            return 0.0;

        }

    }


}
