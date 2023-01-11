package com.listek.bookstore.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="ProgramyLojalnosciowe")
@Entity
public class LoyaltyProgram {
    @Id
    @GeneratedValue
    private Long id;
    private int bookcoins;

    public LoyaltyProgram(Long id, int bookcoins) {
        this.id = id;
        this.bookcoins = bookcoins;
    }

    public LoyaltyProgram() {

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
