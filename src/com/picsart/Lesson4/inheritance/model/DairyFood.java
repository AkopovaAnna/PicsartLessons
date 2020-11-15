package com.picsart.Lesson4.inheritance.model;


import java.util.Calendar;

public class DairyFood extends Product {

    private final double TAX_RATE = 1.2;

    private int producedDate;
    private int expireDate;
    private double weight;

    public DairyFood (String name,  int producedDate, int expireDate, double weight) {
        super(name, "Unknown", 0, 0.0, 2);
        this.producedDate = producedDate;
        this.expireDate = expireDate;
        this.weight = weight;
        setTax(TAX_RATE);
    }

    public int getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(int producedDate) {
        this.producedDate = producedDate;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isInDate() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DATE);
        return expireDate < dayOfWeek;
    }

    public void sell(int sellItemCount) {
        if (isInDate()) {
            super.sell(sellItemCount);
        } else {
            System.out.println("out of date");
        }
    }


    public void notifySupplier() {
        System.out.println("call to 010 288888");
    }

    @Override
    public void printInfo() {
        System.out.println("name: " + getName());
        System.out.println("quantity: " + getQuantity()) ;
        System.out.println("selling price: " + sellingPrice());
        System.out.println("price: " + sellingPrice());
    }
}
