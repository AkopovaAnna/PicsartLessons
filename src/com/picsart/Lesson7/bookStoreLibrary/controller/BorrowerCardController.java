package com.picsart.Lesson7.bookStoreLibrary.controller;

import com.picsart.Lesson7.bookStoreLibrary.model.BookStoreLibrary;
import com.picsart.Lesson7.bookStoreLibrary.model.BorrowerCard;
import com.picsart.Lesson7.bookStoreLibrary.service.impl.BorrowerService;
import com.picsart.Lesson7.bookStoreLibrary.validation.BorrowerCardValidator;
import com.picsart.Lesson7.bookStoreLibrary.exception.CardNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;


public class BorrowerCardController {

    private BorrowerService borrowerService;

    public BorrowerCardController(BookStoreLibrary store) {
        this.borrowerService = new BorrowerService(store);
    }

    public BorrowerCard createBorrower(Scanner sc) throws Exception {

        BorrowerCard borrowerCard = new BorrowerCard();
        try {
            System.out.println("Add Borrower");

            System.out.println("Enter borrower card number: ");
            String cardNum = sc.nextLine();

            if (BorrowerCardValidator.isValidCardNumber(cardNum))
                borrowerCard.setCardNumb(cardNum);
            borrowerService.addBorrower(borrowerCard);


        } catch (InputMismatchException | CardNumberException e) {
            sc.nextLine();
            throw new Exception("enter valid value " + e.getMessage());
        }
        return borrowerCard;
    }
}
