package com.picsart.Lesson7.bookStoreLibrary.service;



public interface BookSellInterface {
    Integer sell(Integer bookId);
    Integer returnBook(int bookSellId, Integer bookId);
}
