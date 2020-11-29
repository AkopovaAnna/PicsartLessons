package com.picsart.Lesson7.bookStoreLibrary.utils;


import com.picsart.Lesson7.bookStoreLibrary.converter.BookConverter;
import com.picsart.Lesson7.bookStoreLibrary.converter.EBookConverter;
import com.picsart.Lesson7.bookStoreLibrary.model.Book;

import java.io.IOException;

public class FileReaderAndWriter {

    BookConverter bookConverter = new BookConverter();
    EBookConverter eBookConverter = new EBookConverter();

    public Book[] readFromFile() throws IOException {
        String fileName = "C:\\Users\\user\\Documents\\book.txt";
        String[] lines = FileProvider.getFileFromPath(fileName);
        return bookConverter.convertToBook(lines);
    }

    public Book[] readFromEbookFile() throws IOException {
        String fileName = "C:\\Users\\user\\Documents\\ebook.txt";
        String[] lines = FileProvider.getFileFromPath(fileName);
        return eBookConverter.convertToBook(lines);
    }


    public void writeToFile(Book[] books) throws IOException {
        bookConverter.convertToFile(books);
    }


    public void writeEbookToFile(Book[] books) throws IOException {
        eBookConverter.convertToFile(books);
    }

}
