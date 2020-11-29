package com.picsart.Lesson7.bookStoreLibrary.service;



public interface BookSellInterface {
    void sell(Integer bookId);
    Integer returnBook(int bookSellId, Integer bookId);
}
