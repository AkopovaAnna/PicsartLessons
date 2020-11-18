package com.picsart.Lesson5.model.book;

import com.picsart.Lesson5.BookInterface;


public class PaperBook extends Book implements BookInterface {

    private String material;
    private boolean isAvailable;
    private boolean isSellable;//rent or sell
    private int numberOfCopies;

    public PaperBook(int bookId) {
        super(bookId);
        isAvailable = true;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isSellable() {
        return isSellable;
    }

    public void setSellable(boolean sellable) {
        isSellable = sellable;
    }

    @Override
    public void repair() {
        System.out.println("paper book will be repaired");
    }

    @Override
    public void deliver() {
        System.out.println("will be delivered by taxi");
    }

    @Override
    public void bonusGift() {
        System.out.println("give client one more book as gift");
    }
}
