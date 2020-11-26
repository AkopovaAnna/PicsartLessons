package com.picsart.Lesson7.bookStoreLibrary.model;


public class PaperBook extends Book {

    private String material;
    private boolean isSellable;//rent or sell
    private int numberOfCopies;


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

    public boolean isSellable() {
        return isSellable;
    }

    public void setSellable(boolean sellable) {
        isSellable = sellable;
    }

    @Override
    public String toString() {
        return getTitle() + "," + getAuthor() + "," + getLanguage()
                + "," + getPrice() + "," + getMaterial() + "," + getNumberOfCopies()
                + ',' + sellableVal(isSellable);
    }


    private String sellableVal(boolean val) {
        if (isSellable) {
            return "CanSell";
        }
        return "CanRent";
    }

}
