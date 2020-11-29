package com.picsart.Lesson7.bookStoreLibrary.controller;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.Ebook;
import com.picsart.Lesson7.bookStoreLibrary.service.impl.EbookServiceImpl;
import com.picsart.Lesson7.bookStoreLibrary.utils.FileReaderAndWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static com.picsart.Lesson7.bookStoreLibrary.utils.InputToBookSetter.bookData;

public class EbookController {

    private EbookServiceImpl ebookService;
    private FileReaderAndWriter readAndWrite = new FileReaderAndWriter();

    public EbookController(BookStoreLibrary store) {
        this.ebookService = new EbookServiceImpl(store);
    }

    public Ebook createEBook(Scanner sc) {
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

    public void downloadBook(Scanner sc) {
        System.out.println("Enter book id you want to sell");
        Integer id = sc.nextInt();
        sc.nextLine();
        if (ebookService.store.getCurrentBookCount() > 0) {

            ebookService.download(id);
        }
    }

    public void addEBookToFile() throws FileNotFoundException {
        try {
            Book[] allBooks = ebookService.store.getBooks();
            readAndWrite.writeEbookToFile(allBooks);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new FileNotFoundException("file not found");
        }
    }


    public void addContentToEBook() {
        try {
            Book[] books = readAndWrite.readFromEbookFile();
            for (int i = 0; i < 3; i++) {
                System.out.println(books[i].getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printEbookInfo(Scanner sc) {
        System.out.println("enter book id to get info");
        Integer id = sc.nextInt();
        sc.nextLine();
        ebookService.printEBookInfoById(id);
    }
}
