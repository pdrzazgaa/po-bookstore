package com.listek.bookstore.models;


import jakarta.persistence.*;

@Table(name="ProgramyLojalnosciowe")
@Entity
public class LoyaltyProgram {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="Bookcoiny")
    private int bookcoins;

    @OneToOne
    @JoinColumn(name="KlientID")
    private Client client;

    public LoyaltyProgram(Long id, int bookcoins, Client client) {
        this.id = id;
        this.bookcoins = bookcoins;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
