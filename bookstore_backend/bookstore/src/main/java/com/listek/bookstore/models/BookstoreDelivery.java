package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="DostawyDoKsiegarni")
@Entity
public class BookstoreDelivery extends Delivery{

    public BookstoreDelivery(Long id, float cost, Address address) {
        super(id, cost, address);
    }

    public BookstoreDelivery() {

    }
}
