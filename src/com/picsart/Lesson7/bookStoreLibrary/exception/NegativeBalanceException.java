package com.picsart.Lesson7.bookStoreLibrary.exception;

public class NegativeBalanceException extends RuntimeException {

    private String message = null;

    public NegativeBalanceException(){
        super();

    }

    public NegativeBalanceException(String message) {
        super(message);
        this.message = message;
    }
}
