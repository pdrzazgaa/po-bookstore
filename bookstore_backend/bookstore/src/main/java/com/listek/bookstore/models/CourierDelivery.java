package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="DostawaKurierem")
@Entity
public class CourierDelivery extends Delivery{

    private static final double COURIERDELIVERYCOST = 13.99;

    public CourierDelivery(Address address, Order order) {
        super(COURIERDELIVERYCOST, address, order);
    }

    public CourierDelivery() {

    }
}
