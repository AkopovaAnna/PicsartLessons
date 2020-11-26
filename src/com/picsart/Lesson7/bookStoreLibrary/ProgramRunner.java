package com.picsart.Lesson7.bookStoreLibrary;

import com.picsart.Lesson7.bookStoreLibrary.service.impl.MenuProcessingImpl;

import java.util.Scanner;

public class ProgramRunner {


    public static void main(String[] args) {
        MenuProcessingImpl menu = new MenuProcessingImpl();
        Scanner sc = new Scanner(System.in);

        menu.menuProcessing(sc);


    }


}
