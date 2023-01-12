package com.listek.bookstore.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Table(name="Koszyki")
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="OstatniaAktywnosc")
    private LocalDateTime lastActivity;
    @OneToMany(mappedBy = "cart")
    private ArrayList<CartItem> cartItems;
    @ManyToOne
    @JoinColumn(name="KlientID")
    private Client client;

    public Cart(Long id) {
        this.id = id;
    }

    public Cart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LocalDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
