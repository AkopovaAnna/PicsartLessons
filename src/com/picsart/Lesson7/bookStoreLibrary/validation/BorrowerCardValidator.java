package com.picsart.Lesson7.bookStoreLibrary.validation;

import com.picsart.Lesson7.bookStoreLibrary.exception.CardNumberException;

public class BorrowerCardValidator {

    public static boolean isValidCardNumber(String cardNumber) throws CardNumberException {
        if(cardNumber.matches("[a-zA-Z0-9]*")) {
            return true;
        } else {
            throw new CardNumberException("invalid card number, only letters and numbers");
        }
    }
}
