package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="DostawyDoKsiegarni")
@Entity
public class BookstoreDelivery extends Delivery{

    public BookstoreDelivery(double cost, Address address, Order order) {
        super(cost, address, order);
    }

    public BookstoreDelivery() {

    }
}
