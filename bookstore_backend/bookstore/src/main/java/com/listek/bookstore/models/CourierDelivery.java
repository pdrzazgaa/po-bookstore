package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="DostawaKurierem")
@Entity
public class CourierDelivery extends Delivery{

    public CourierDelivery(Long id, float cost, Address address) {
        super(id, cost, address);
    }

    public CourierDelivery() {

    }
}
