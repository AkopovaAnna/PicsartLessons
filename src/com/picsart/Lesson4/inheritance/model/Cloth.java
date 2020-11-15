package com.picsart.Lesson4.inheritance.model;

public class Cloth extends Product {

    private final double TAX_RATE = 2.2;

    private String size;
    private String color;
    private String material;
    private String type;
    private boolean isDamaged;

    public Cloth(String name, String size, String color, String material) {
        super(name, "Unknown", 0, 0.0, 2);
        this.size = size;
        this.color = color;
        this.material = material;
        setTax(TAX_RATE);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    @Override
    public void sell(int sellItemCount) {
        if (isDamaged) {
            double DAMAGE_PERCENT = 45;
            setPrice(super.applySale(DAMAGE_PERCENT));
        }
        super.sell(sellItemCount);
    }

    public void returnedItem() {
        if ("underwear".equals(type)) {
            System.out.println("could not be returned");
        }
    }

    @Override
    public void notifySupplier() {
        System.out.println("call to 010 211999");
    }

    @Override
    public void printInfo() {
        System.out.println("type: " + type);
        System.out.println("name: " + getName());
        System.out.println("size: " + size);
        System.out.println("price: " + sellingPrice());
    }
}

