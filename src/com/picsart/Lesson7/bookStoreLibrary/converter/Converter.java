package com.picsart.Lesson7.bookStoreLibrary.converter;


import com.picsart.Lesson7.bookStoreLibrary.model.Book;

import java.io.IOException;

public interface Converter {
    Book[] convertToBook(String[] lines);
    void convertToFile(Book[] books) throws IOException;
}
