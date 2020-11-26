package com.picsart.Lesson7.bookStoreLibrary.service;



public interface EbookService extends BookService {
    void preview(Integer bookId);
    void download(Integer bookId);
}
