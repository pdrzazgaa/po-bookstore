package com.listek.bookstore.models;

import jakarta.persistence.Entity;

@Entity
public class BookstoreDelivery extends Delivery{

    public BookstoreDelivery(Long id, float cost, Address address) {
        super(id, cost, address);
    }

    public BookstoreDelivery() {

    }
}
