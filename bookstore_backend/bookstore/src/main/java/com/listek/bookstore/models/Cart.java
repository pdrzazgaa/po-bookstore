package com.listek.bookstore.models;

import java.util.ArrayList;

public class Cart {

    private long id;
    private ArrayList<CartItem> cartItems;

    public Cart(long id, ArrayList<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
