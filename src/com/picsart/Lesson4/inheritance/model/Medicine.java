package com.picsart.Lesson4.inheritance.model;

public class Medicine extends Product {

    private final double TAX_RATE = 4.5;
    private boolean isWithReceipt;
    private String instruction;
    private String composition;
    private String disease;

    public Medicine(String name, boolean isWithReceipt, String instruction, String composition, String disease) {
        super(name, "Unknown", 0, 0.0, 2);
        this.isWithReceipt = isWithReceipt;
        this.instruction = instruction;
        this.composition = composition;
        this.disease = disease;
        setTax(TAX_RATE);
    }

    public boolean isWithReceipt() {
        return isWithReceipt;
    }

    public void setWithReceipt(boolean withReceipt) {
        isWithReceipt = withReceipt;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void sell(int sellItemCount) {
        if (!isWithReceipt) {
            super.sell(sellItemCount);
        } else {
            System.out.println("need a Receipt");
        }
    }

    public void notifySupplier() {
        System.out.println("call to 010 288888");
    }

    public void keepInFridge() {
        if (instruction.contains("refrigerator")) {
            System.out.println("keep in fridge");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("name: " + getName());
        System.out.println("Receipt is needed: " + isWithReceipt);
        System.out.println("price: " + sellingPrice());
    }
}
