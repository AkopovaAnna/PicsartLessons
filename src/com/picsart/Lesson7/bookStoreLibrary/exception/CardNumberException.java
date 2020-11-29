package com.picsart.Lesson7.bookStoreLibrary.exception;

public class CardNumberException extends RuntimeException {

    private String message = null;

    public CardNumberException(){
        super();

    }

    public CardNumberException(String message) {
        super(message);
        this.message = message;
    }
}
