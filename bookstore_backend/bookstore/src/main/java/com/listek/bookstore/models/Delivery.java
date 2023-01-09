package com.listek.bookstore.models;

public class Delivery {
    private Long id;
    private float cost;
    private Address address;

    public Delivery(Long id, float cost, Address address) {
        this.id = id;
        this.cost = cost;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
