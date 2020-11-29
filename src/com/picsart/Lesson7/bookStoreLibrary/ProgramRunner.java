package com.picsart.Lesson7.bookStoreLibrary;

import com.picsart.Lesson7.bookStoreLibrary.controller.MenuController;

import java.util.Scanner;

public class ProgramRunner {


    public static void main(String[] args) {
        MenuController executor = new MenuController();
        Scanner sc = new Scanner(System.in);
        executor.menuProcessing(sc);
    }

}
