package com.picsart.Lesson5.model.book;

import com.picsart.Lesson5.BookInterface;

public class Ebook extends Book implements BookInterface {

    private String extensionTyp;
    private double size;
    private int downloadedCount;

    public Ebook(int bookId) {
        super(bookId);
        downloadedCount = 0;
    }


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
    public void repair() {
        System.out.println("the file was not working, will be repaired");
    }

    @Override
    public void deliver() {
        System.out.println("the ebook will be sent by an email");
    }

    @Override
    public void bonusGift() {
        System.out.println("you will have sale after buying more than 10books");
    }
}
