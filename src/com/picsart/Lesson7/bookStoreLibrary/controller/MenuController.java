package com.picsart.Lesson7.bookStoreLibrary.controller;

import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;

import java.util.Scanner;

public class MenuController {

    BookStoreLibrary booksDb = new BookStoreLibrary();

    PaperBookController pbController = new PaperBookController(booksDb);
    EbookController ebController = new EbookController(booksDb);
    BorrowerCardController cardController = new BorrowerCardController(booksDb);


    public void menuProcessing(Scanner sc) {
        boolean repeat = true;


        while (repeat) {
            try {
                switch (menu(sc)) {
                    case 1 -> pbController.createPBook(sc);
                    case 2 -> ebController.createEBook(sc);
                    case 3 -> cardController.createBorrower(sc);
                    case 4 -> pbController.buyBook(sc);
                    case 5 -> ebController.downloadBook(sc);
                    case 6 -> pbController.returnBook(sc);
                    case 7 -> pbController.checkInBook(sc);
                    case 8 -> pbController.checkOutBook(sc);
                    case 9 -> pbController.addBookToFile();
                    case 10 -> pbController.addContentToBook();
                    case 11 -> ebController.addEBookToFile();
                    case 12 -> ebController.addContentToEBook();
                    case 13 -> ebController.printEbookInfo(sc);
                    case 14 -> pbController.printBookInfo(sc);
                    case 0 -> repeat = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }


    }


    private int menu(Scanner in) {

        System.out.println("\nSelect a Function");
        System.out.println("1. Add Book");
        System.out.println("2. Add Ebook");
        System.out.println("3. Add Borrower");
        System.out.println("4. Buy Book");
        System.out.println("5. Download Book");
        System.out.println("6. Return Book");
        System.out.println("7. Check in Book");
        System.out.println("8. Check out Book");
        System.out.println("9. Add paper books to file");
        System.out.println("10. Get 1st 3 books from paperbook file");
        System.out.println("11. Add ebook books to file");
        System.out.println("12. Get 1st 3 books from ebook file");
        System.out.println("13. print ebook info");
        System.out.println("14. print paper book info");
        System.out.println("0. Exit");
        int choice = in.nextInt();
        in.nextLine();
        if (choice > 0 && choice < 15) {
            return choice;
        } else {
            System.out.println("You will exit!");
            return 0;
        }
    }


}
