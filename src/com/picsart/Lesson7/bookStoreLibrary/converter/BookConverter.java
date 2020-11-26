package com.picsart.Lesson7.bookStoreLibrary.converter;

import com.picsart.Lesson7.bookStoreLibrary.model.Book;
import com.picsart.Lesson7.bookStoreLibrary.model.PaperBook;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BookConverter implements Converter {

    @Override
    public Book[] convertToBook(String[] lines) {

        Book[] books = new PaperBook[lines.length];
        for (int i = 0; i < lines.length; i++) {
            books[i] = createPBook(lines[i].split(","));
        }

        return books;

    }

    @Override
    public void convertToFile(Book[] books) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof PaperBook) {

                lines.add(book.toString());
            }
        }
        getFileToWrite(lines);
    }


    public static void getFileToWrite(List<String> lines) throws IOException {
        String pathW = "C:\\Users\\user\\Documents\\book.txt";
        Files.write(Paths.get(pathW),
                lines,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    private static Book createPBook(String[] tokens) {
        PaperBook paperBook = new PaperBook();
        paperBook.setTitle(tokens[1]);
        paperBook.setAuthor(tokens[2]);
        paperBook.setLanguage(tokens[3]);
        paperBook.setPrice(Double.parseDouble(tokens[4]));
        paperBook.setMaterial(tokens[5]);
        paperBook.setNumberOfCopies(Integer.parseInt(tokens[6]));
        paperBook.setSellable(convertSellableStatus(tokens[8]));
        return paperBook;
    }


    private static Boolean convertSellableStatus(String val) {
        if ("CanRent".equals(val)) {
            return false;
        } else if ("CanSell".equals(val)) {
            return true;
        } else {
            System.out.println("exception");
            return false;
        }
    }
}
