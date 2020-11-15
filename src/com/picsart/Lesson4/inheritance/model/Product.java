package com.picsart.Lesson4.inheritance.model;

public class Product {

    private String name;
    private String supplier;
    private int quantity;
    private String unitOfProduct; //kg, package, litre, milligram ...
    private double price;
    private double tax;
    private int minNotifyCount;

    public Product(String name, String supplier, int quantity, double price, int minNotifyCount) {
        this.name = name;
        this.supplier = supplier;
        this.quantity = quantity;
        this.price = price;
        this.minNotifyCount = minNotifyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnitOfProduct() {
        return unitOfProduct;
    }

    public void setUnitOfProduct(String unitOfProduct) {
        this.unitOfProduct = unitOfProduct;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double sellingPrice() {
        return price + price * tax / 100;
    }

    public double applySale(double percent) {
        double sellingPrice = sellingPrice();
        double change = sellingPrice * (percent * 0.01);
        return sellingPrice - change;
    }


    public void sell(int sellItemCount) {
        if (this.quantity > sellItemCount) {
            this.quantity = this.quantity - sellItemCount;
            if (this.quantity < minNotifyCount) {
                notifySupplier();
            }
        } else {
            System.out.println("no that count of " + sellItemCount + " items");
        }

    }


    public void notifySupplier() {

    }

    public void printInfo() {

    }

}
