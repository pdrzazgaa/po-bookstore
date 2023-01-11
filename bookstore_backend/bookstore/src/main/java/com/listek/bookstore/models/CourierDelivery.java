package com.listek.bookstore.models;

import jakarta.persistence.Entity;

@Entity
public class CourierDelivery extends Delivery{

    public CourierDelivery(Long id, float cost, Address address) {
        super(id, cost, address);
    }

    public CourierDelivery() {

    }
}
