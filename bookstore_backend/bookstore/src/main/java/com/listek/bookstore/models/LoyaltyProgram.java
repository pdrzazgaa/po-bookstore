package com.listek.bookstore.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name="ProgramyLojalnosciowe")
@Entity
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="Bookcoiny")
    private int bookcoins = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="KlientID")
    private Client client;

    public LoyaltyProgram(Long id, int bookcoins, Client client) {
        this.id = id;
        this.bookcoins = bookcoins;
        this.client = client;
    }

    public void addBookCoins(int bookcoins){
        this.bookcoins += bookcoins;
    }

    public boolean removeBookCoins(int bookcoins){
        if (this.bookcoins > bookcoins) {
            this.bookcoins -= bookcoins;
            return true;
        } else {
            return false;
        }
    }
}
