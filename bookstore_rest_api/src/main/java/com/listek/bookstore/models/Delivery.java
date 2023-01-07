package com.listek.bookstore.models;

public class Delivery {
    private int id;
    private float cost;
    private Address address;

    public Delivery(int id, float cost, Address address) {
        this.id = id;
        this.cost = cost;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
