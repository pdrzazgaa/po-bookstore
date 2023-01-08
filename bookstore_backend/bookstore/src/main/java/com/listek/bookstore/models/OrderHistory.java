package com.listek.bookstore.models;

import java.util.ArrayList;

public class OrderHistory {
    private long id;
    private ArrayList<Order> orders;

    public OrderHistory(long id, ArrayList<Order> orders) {
        this.id = id;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
