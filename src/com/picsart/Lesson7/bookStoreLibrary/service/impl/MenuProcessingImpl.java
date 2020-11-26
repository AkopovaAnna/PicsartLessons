package com.picsart.Lesson7.bookStoreLibrary.service.impl;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.Ebook;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;
import com.picsart.Lesson7.bookStoreLibrary.utils.FileReaderAndWriter;

import java.io.IOException;
import java.util.Scanner;

public class MenuProcessingImpl {
    public BookSellServiceImpl bookSell = new BookSellServiceImpl();
    public BookRentServiceImpl bookRent = new BookRentServiceImpl();
    public EbookServiceImpl ebookService = new EbookServiceImpl();
    BookServiceImpl bookService = new BookServiceImpl();
    FileReaderAndWriter readAndWrite = new FileReaderAndWriter();

    public void menuProcessing(Scanner sc) {
        boolean repeat = true;


        while (repeat) {

            switch (menu(sc)) {
                case 1 -> createPBook(sc);
                case 2 -> createEBook(sc);
                case 3 -> buyBook(sc);
                case 4 -> downloadBook(sc);
                case 5 -> returnBook(sc);
                case 6 -> checkInBook(sc);//not tested
                case 7 -> checkOutBook(sc);//not tested
                case 8 -> addBookToFile();
                case 9 -> addContentToBook();
                case 10 -> addEBookToFile();
                case 11 -> addContentToEBook();
                case 0 -> repeat = false;
            }
        }
    }

    private int menu(Scanner in) {

        System.out.println("\nSelect a Function");
        System.out.println("1. Add Book");
        System.out.println("2. Add Ebook");
        System.out.println("3. Buy Book");
        System.out.println("4. Download Book");
        System.out.println("5. Return Book");
        System.out.println("6. Check in Book");
        System.out.println("7. Check out Book");
        System.out.println("8. Add paper books to file");
        System.out.println("9. Get 1st 3 books from paperbook file");
        System.out.println("10. Add ebook books to file");
        System.out.println("11. Get 1st 3 books from ebook file");
        System.out.println("0. Exit");
        int choice = in.nextInt();
        in.nextLine();
        if (choice > 0 && choice < 12) {
            return choice;
        } else {
            System.out.println("You will exit!");
            return 0;
        }
    }

    private PaperBook createPBook(Scanner sc) {
        PaperBook pb = new PaperBook();
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
    }

    private Ebook createEBook(Scanner sc) {
        Ebook ebook = new Ebook();
        System.out.println("Add EBook");
        bookData(sc, ebook);
        System.out.println("Enter extension: ");
        String extension = sc.nextLine();
        System.out.println("Enter size: ");
        double size = sc.nextDouble();
        sc.nextLine();


        ebook.setExtensionTyp(extension);
        ebook.setSize(size);

        System.out.println(ebook.toString());

        ebookService.addBook(ebook);
        return ebook;

    }

    private void bookData(Scanner sc, Book book) {
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter author: ");
        String author = sc.nextLine();
        System.out.println("Enter language: ");
        String language = sc.nextLine();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        book.setTitle(title);
        book.setAuthor(author);
        book.setLanguage(language);
        book.setPrice(price);

    }

    private void buyBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        if (bookService.bookStore.getCurrentBookCount() > 0) {

            bookSell.service.bookStore = bookService.bookStore;
            bookSell.sell(id);
        }
    }

    private void downloadBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        if (ebookService.store.getCurrentBookCount() > 0) {

            bookSell.service.bookStore = bookService.bookStore;
            ebookService.download(id);
        }
    }


    private void returnBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        int soldBookId = sc.nextInt();
        sc.nextLine();
        bookSell.returnBook(soldBookId, id);
    }

    private void checkInBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        int clientId = sc.nextInt();
        sc.nextLine();
        bookRent.checkIn(id, clientId);
    }

    private void checkOutBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        int clientId = sc.nextInt();
        sc.nextLine();
        bookRent.checkOut(id, clientId);
    }

    private void addBookToFile() {
        try {
            Book[] allBooks = bookService.bookStore.getBooks();
            readAndWrite.writeToFile(allBooks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void addEBookToFile() {
        try {
            Book[] allBooks = ebookService.store.getBooks();
            readAndWrite.writeEbookToFile(allBooks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void addContentToBook() {
        try {
            Book[] books = readAndWrite.readFromFile();
            for (int i = 0; i < 3; i++) {
                System.out.println(books[i].getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addContentToEBook() {
        try {
            Book[] books = readAndWrite.readFromEbookFile();
            for (int i = 0; i < 3; i++) {
                System.out.println(books[i].getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
