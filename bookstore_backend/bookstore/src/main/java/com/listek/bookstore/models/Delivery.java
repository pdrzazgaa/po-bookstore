package com.listek.bookstore.models;

public class Delivery {
    private long id;
    private float cost;
    private Address address;

    public Delivery(long id, float cost, Address address) {
        this.id = id;
        this.cost = cost;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
