package com.listek.bookstore.models;

import jakarta.persistence.*;

@Table(name="PozycjeKoszyka")
@Entity
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="ilosc")
    private int quantity;

    public CartItem(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CartItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
