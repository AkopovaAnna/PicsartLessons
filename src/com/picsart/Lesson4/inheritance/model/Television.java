package com.picsart.Lesson4.inheritance.model;

public class Television extends Product {

    private final double TAX_RATE = 10.5;
    private String model;
    private boolean isSmart = false;
    private int screenSize;


    public Television(String name, String model, boolean isSmart, int screenSize) {
        super(name, "Unknown", 0, 0.0, 2);
        this.model = model;
        this.isSmart = isSmart;
        this.screenSize = screenSize;
        setTax(TAX_RATE);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean smart) {
        isSmart = smart;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void connectToWifi() {
        if (isSmart) {
            System.out.println("tv is smart, connect to internet");
        } else {
            System.out.println("your tv is not smart");
        }
    }

    @Override
    public void notifySupplier() {
        System.out.println("call to 010 345055");
    }

    @Override
    public void printInfo() {
        System.out.println("name: " + getName());
        System.out.println("screen size: " + screenSize);
        System.out.println("smart TV: " + isSmart);
        System.out.println("price: " + sellingPrice());
    }
}
