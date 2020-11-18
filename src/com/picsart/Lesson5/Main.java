package com.picsart.Lesson5;

import com.picsart.Lesson5.model.book.Ebook;
import com.picsart.Lesson5.model.book.PaperBook;
import com.picsart.Lesson5.model.staff.*;
import com.picsart.Lesson5.service.BookStoreService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        PaperBook harryPotter = new PaperBook(1);
        harryPotter.setTitle("Harry Potter");
        harryPotter.setAuthor("Rowling");
        harryPotter.setLanguage("Eng");
        harryPotter.setNumberOfCopies(10);
        harryPotter.setPrice(4550);
        harryPotter.setMaterial("hardcover");
        harryPotter.setSellable(true);

        PaperBook vardananq = new PaperBook(2);
        vardananq.setTitle("Vardananq");
        vardananq.setAuthor("Derenik Demirtchyan");
        vardananq.setLanguage("Arm");
        vardananq.setNumberOfCopies(5);
        vardananq.setMaterial("hardcover");
        vardananq.setPrice(3200);
        vardananq.setSellable(false);

        Ebook fistHeadJava = new Ebook(3);
        fistHeadJava.setTitle("First Head Java");
        fistHeadJava.setAuthor("Oreilly");
        fistHeadJava.setLanguage("Eng");
        fistHeadJava.setPrice(5400);
        fistHeadJava.setExtensionTyp("pdf");
        fistHeadJava.setSize(4.5);

        Librarian librarian = new Librarian();
        librarian.setPersonId(1);
        librarian.setfName("Armine");
        librarian.setlName("Petrosyan");
        librarian.setEmail("apet@gmail.com");
        librarian.setEntranceDay(convertStringToDate("01/02/2019"));
        librarian.setPosition("cashier");
        librarian.setSalary(200_000);

        DeveloperSupporter devSupport = new DeveloperSupporter();
        devSupport.setPersonId(2);
        devSupport.setfName("Poghos");
        devSupport.setlName("Poghosyan");
        devSupport.setEmail("p@gmail.com");
        devSupport.setEntranceDay(convertStringToDate("05/12/2018"));
        devSupport.setPosition("app supporter");
        devSupport.setSalary(400_000);

        BookSellHelper bookSeller = new BookSellHelper();
        bookSeller.setPersonId(3);
        bookSeller.setfName("karine");
        bookSeller.setlName("Vardanyan");
        bookSeller.setEmail("vk@gmail.com");
        bookSeller.setEntranceDay(convertStringToDate("15/11/2018"));
        bookSeller.setPosition("seller");
        bookSeller.setSalary(150_000);


        BookStoreService bs = new BookStoreService();

        System.out.println("--- Add Books----");
        bs.addBook(harryPotter);
        bs.addBook(vardananq);
        bs.addEbook(fistHeadJava);
        System.out.println("+++++++++++");
        bs.getAllBooksInfo();

        System.out.println("----Add Employees----");
        bs.addEmployee(librarian);
        bs.addEmployee(devSupport);
        bs.addEmployee(bookSeller);
        System.out.println("++++++++++++++++++");


        System.out.println("----Total number of Books---");
        System.out.println(bs.getAllBooksCount());
        System.out.println("----Employee info-----------");
        bs.getAllEmployees();

        System.out.println("-----librarian bonus----");
        librarian.giveBonus();
        System.out.println("---ebook deliver---");
        fistHeadJava.deliver();
        System.out.println("---paper book deliver---");
        harryPotter.deliver();

        System.out.println("----sell book---- bookSeller");
        bs.sellPaperBook(3, 1);
        bs.sellPaperBook(3, 2);
        bs.sellEbook(3);

        System.out.println(bs.getAllBooksCount());
        System.out.println("+++++++++++++++");


        System.out.println("----- check out book-----");
        bs.checkOut(2, 1);
        bs.getAllBooksInfo();
        System.out.println("+++++++++++++++");

        System.out.println("----- check in book-----");
        bs.checkIn(vardananq, 1);
        bs.getAllBooksInfo();
        System.out.println("+++++++++++++++");

        System.out.println("---------- return book------");
        bs.returnSellBook(2, harryPotter);
        bs.getAllBooksInfo();
        System.out.println("+++++++++++++++");

    }

    private static Date convertStringToDate(String date) {

        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("could not parse, invalid input");
        }
        return new Date();
    }
}
