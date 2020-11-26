package com.picsart.Lesson7.bookStoreLibrary.converter;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.Ebook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EBookConverter implements Converter {

    @Override
    public Book[] convertToBook(String[] lines) {

        Book[] books = new Ebook[lines.length];
        for (int i = 0; i < lines.length; i++) {
            books[i] = createEBook(lines[i].split(","));
        }

        return books;
    }

    @Override
    public void convertToFile(Book[] books) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof Ebook) {

                lines.add(book.toString());
            }
        }
        getFileToWrite(lines);
    }

    public static void getFileToWrite(List<String> lines) throws IOException {
        String pathW = "C:\\Users\\user\\Documents\\ebook.txt";
        Files.write(Paths.get(pathW),
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public static Book createEBook(String[] tokens) {
        Ebook paperBook = new Ebook();
        paperBook.setTitle(tokens[1]);
        paperBook.setAuthor(tokens[2]);
        paperBook.setLanguage(tokens[3]);
        paperBook.setPrice(Double.parseDouble(tokens[4]));
        paperBook.setSize(Double.parseDouble(tokens[5]));
        paperBook.setExtensionTyp(tokens[6]);
        paperBook.setDownloadedCount(Integer.parseInt(tokens[8]));
        return paperBook;
    }
}
