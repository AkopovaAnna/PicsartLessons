package com.picsart.Lesson7.bookStoreLibrary.controller;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.service.impl.BookRentServiceImpl;
import com.picsart.Lesson7.bookStoreLibrary.service.impl.BookSellServiceImpl;
import com.picsart.Lesson7.bookStoreLibrary.service.impl.BookServiceImpl;
import com.picsart.Lesson7.bookStoreLibrary.service.impl.BorrowerService;
import com.picsart.Lesson7.bookStoreLibrary.utils.FileReaderAndWriter;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.picsart.Lesson7.bookStoreLibrary.utils.InputToBookSetter.bookData;

public class PaperBookController {


    BookServiceImpl bookService;
    BookSellServiceImpl bookSell;
    BookRentServiceImpl bookRent;
    BorrowerService borrowerService;
    FileReaderAndWriter readAndWrite = new FileReaderAndWriter();

    public PaperBookController(BookStoreLibrary store) {
        bookService = new BookServiceImpl(store);
        borrowerService = new BorrowerService(store);
        this.bookSell = new BookSellServiceImpl(bookService);
        this.bookRent = new BookRentServiceImpl(bookService, borrowerService);
    }

    public PaperBook createPBook(Scanner sc) {

        PaperBook pb = new PaperBook();

        try {
            System.out.println("Add Book");

            bookData(sc, pb);
            System.out.println("Enter material: ");
            String material = sc.nextLine();
            System.out.println("Enter number of copies: ");
            int numOfCopies = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter true or false; isSellable: ");
            boolean isSellable = sc.nextBoolean();
            sc.nextLine();


            pb.setNumberOfCopies(numOfCopies);
            pb.setMaterial(material);
            pb.setSellable(isSellable);

            System.out.println("You have added book");
            System.out.println(pb.getBookId() + ": " +
                    pb.toString());


            bookService.addBook(pb);
            return pb;
        } catch (InputMismatchException ex) {
            sc.nextLine();
            throw new InputMismatchException("invalid input");
        }

    }


    public void buyBook(Scanner sc) {
        System.out.println("Enter book id you want to buy");
        Integer id = sc.nextInt();
        sc.nextLine();
        if (bookService.bookStore.getCurrentBookCount() > 0) {

            bookSell.sell(id);

        }
    }

    public void returnBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        int soldBookId = sc.nextInt();
        sc.nextLine();
        bookSell.returnBook(soldBookId, id);
    }


    public void checkInBook(Scanner sc) throws Exception {
        if (bookService.bookStore.getCurrentBorrowerCount() > 0) {
            System.out.println("Enter book id you want to check in");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter borrower id who want to check in");
            int clientId = sc.nextInt();
            sc.nextLine();
            bookRent.checkIn(id, clientId);
        } else {
            throw new Exception("please create borrower");
        }

    }

    public void checkOutBook(Scanner sc) {
        if (bookService.bookStore.getCurrentBorrowerCount() > 0) {
            System.out.println("Enter book id you want to check out");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter borrower id who want to check out");
            int clientId = sc.nextInt();
            sc.nextLine();
            bookRent.checkOut(id, clientId);
        } else {
            throw new RuntimeException("please create borrower");
        }
    }

    public void addBookToFile() {
        try {
            Book[] allBooks = bookService.bookStore.getBooks();
            readAndWrite.writeToFile(allBooks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void addContentToBook() {
        try {
            Book[] books = readAndWrite.readFromFile();
            for (int i = 0; i < 3; i++) {
                System.out.println(books[i].getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBookInfo(Scanner sc) {
        System.out.println("enter book id to get info");
        Integer id = sc.nextInt();
        sc.nextLine();
        bookService.printBookInfoById(id);
    }

}
