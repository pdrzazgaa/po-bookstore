package com.listek.bookstore.models;

public class LoyaltyProgram {
    private Long id;
    private int bookcoins;

    public LoyaltyProgram(Long id, int bookcoins) {
        this.id = id;
        this.bookcoins = bookcoins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBookcoins() {
        return bookcoins;
    }

    public void setBookcoins(int bookcoins) {
        this.bookcoins = bookcoins;
    }
}
