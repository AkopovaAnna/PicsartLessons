package com.picsart.Lesson7.bookStoreLibrary.model;


public class Ebook extends Book {

    private String extensionTyp;
    private double size;
    private int downloadedCount;


    public int getDownloadedCount() {
        return downloadedCount;
    }

    public void setDownloadedCount(int downloadedCount) {
        this.downloadedCount = downloadedCount;
    }

    public String getExtensionTyp() {
        return extensionTyp;
    }

    public void setExtensionTyp(String extensionTyp) {
        this.extensionTyp = extensionTyp;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getTitle() + "," + getAuthor() + "," + getLanguage()
                + "," + getPrice() + "," + getExtensionTyp() + "," + getDownloadedCount()
                + ',' + getSize();
    }

}
