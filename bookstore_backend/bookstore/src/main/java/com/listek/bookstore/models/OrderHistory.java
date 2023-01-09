package com.listek.bookstore.models;

import java.util.ArrayList;

public class OrderHistory {
    private Long id;
    private ArrayList<Order> orders;

    public OrderHistory(Long id, ArrayList<Order> orders) {
        this.id = id;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
