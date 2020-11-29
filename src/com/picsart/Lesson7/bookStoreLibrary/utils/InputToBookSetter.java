package com.picsart.Lesson7.bookStoreLibrary.utils;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;

import java.util.Scanner;

public class InputToBookSetter {

    public static void bookData(Scanner sc, Book book) {
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
}
