package com.picsart.Lesson7.bookStoreLibrary.service;



public interface BookRentService {
    void checkIn(Integer bookId, Integer borrowerId);
    void checkOut(Integer bookId, Integer borrowerId);
}
