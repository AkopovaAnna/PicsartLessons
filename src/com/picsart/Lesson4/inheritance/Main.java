package com.picsart.Lesson4.inheritance;

import com.picsart.Lesson4.inheritance.model.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("---------------Dairy Product------------");
        Product milk = new DairyFood("milk", 10, 14, 2.6);
        milk.setPrice(250);
        milk.setQuantity(20);
        milk.setSupplier("Marila");
        milk.setUnitOfProduct("gram");
        milk.sell(2);
        milk.printInfo();
        System.out.println("=========================================");

        System.out.println("----------Cloth1-----------");
        Cloth tShirt = new Cloth("tShirt", "Xl", "blue", "cotton");
        tShirt.setType("top");
        tShirt.setQuantity(10);
        tShirt.setSupplier("Mango");
        tShirt.setUnitOfProduct("piece");
        tShirt.setPrice(14000);
        tShirt.sell(9);
        tShirt.printInfo();
        System.out.println("=========================================");

        System.out.println("----------Cloth2-----------");
        Cloth pajama = new Cloth("pajama", "M", "orange", "cotton");
        pajama.setType("underwear");
        pajama.setQuantity(100);
        pajama.setSupplier("gap");
        pajama.setUnitOfProduct("piece");
        pajama.setPrice(21000);
        pajama.sell(2);
        pajama.returnedItem();
        pajama.printInfo();
        System.out.println("=========================================");


        System.out.println("----------Furniture-----------");
        Furniture table = new Furniture("table", "wood", 2, 1.6f);
        table.setPrice(100000);
        table.setQuantity(10);
        table.setSupplier("Niko");
        table.setUnitOfProduct("piece");
        table.sell(3);
        table.delivery();
        table.printInfo();
        System.out.println("=========================================");

        System.out.println("----------Medicine-----------");
        Medicine antibiotic = new Medicine("moksicin", true, "drug", "drug", "pneumonia");
        antibiotic.setPrice(4000);
        antibiotic.setQuantity(20);
        antibiotic.setSupplier("alfFarm");
        antibiotic.setUnitOfProduct("package");
        antibiotic.sell(2);
        antibiotic.printInfo();
        System.out.println("=========================================");

        System.out.println("----------Mobile-----------");
        Mobile google = new Mobile("pixel", "Android", "Pixel 2", 4, true);
        google.setPrice(500000);
        google.setQuantity(5);
        google.setSupplier("AllCell");
        google.setUnitOfProduct("piece");
        google.sell(2);
        google.repair();
        google.printInfo();
        System.out.println("=========================================");

        System.out.println("----------Television-----------");
        Television samsung = new Television("Samsung", "SAr324", true, 55);
        samsung.setPrice(200000);
        samsung.setQuantity(3);
        samsung.setSupplier("Zigzag");
        samsung.setUnitOfProduct("piece");
        samsung.connectToWifi();
        samsung.sell(1);
        samsung.printInfo();
        System.out.println("=========================================");

    }
}
