package com.listek.bookstore.models;

public class LoyaltyProgram {
    private long id;
    private int bookcoins;

    public LoyaltyProgram(long id, int bookcoins) {
        this.id = id;
        this.bookcoins = bookcoins;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBookcoins() {
        return bookcoins;
    }

    public void setBookcoins(int bookcoins) {
        this.bookcoins = bookcoins;
    }
}
