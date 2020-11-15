package com.picsart.Lesson4.inheritance.model;

public class Furniture extends Product {

    private final double TAX_RATE = 0.05;
    private final float MIN_DELIVERY_LIMIT = 2;
    private String material;
    private float width;
    private float length;

    public Furniture(String name,String material, float width, float length) {
        super(name, "Unknown", 0, 0.0, 2);
        this.material = material;
        this.width = width;
        this.length = length;
        setTax(TAX_RATE);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void delivery() {
        if (width > MIN_DELIVERY_LIMIT && length > MIN_DELIVERY_LIMIT) {
            System.out.println("we will deliver your item");
        } else {
            System.out.println("take your item");
        }
    }


    public void notifySupplier() {
        System.out.println("call to 010 299999");
    }

    @Override
    public void printInfo() {
        System.out.println("name: " + getName());
        System.out.println("material: " + material);
        System.out.println("price: " + sellingPrice());
    }
}
