package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="DostawaKurierem")
@Entity
public class CourierDelivery extends Delivery{

    public CourierDelivery(double cost, Address address, Order order) {
        super(cost, address, order);
    }

    public CourierDelivery() {

    }
}
