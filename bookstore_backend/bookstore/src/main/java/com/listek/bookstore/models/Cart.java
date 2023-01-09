package com.listek.bookstore.models;

import java.util.ArrayList;

public class Cart {

    private Long id;
    private ArrayList<CartItem> cartItems;

    public Cart(Long id, ArrayList<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
