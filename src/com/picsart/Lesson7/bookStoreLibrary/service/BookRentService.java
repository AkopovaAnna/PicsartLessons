package com.picsart.Lesson7.bookStoreLibrary.service;



public interface BookRentService {
    void checkIn(Integer bookId, int clientId);
    void checkOut(Integer bookId, int clientId);
}
