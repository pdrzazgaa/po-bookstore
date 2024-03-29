package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name="DostawyDoKsiegarni")
@Entity
public class BookstoreDelivery extends Delivery{

    private static final double BOOKSTOREDELIVERYCOST = 0;

    public BookstoreDelivery(Address address, Order order) {
        super(BOOKSTOREDELIVERYCOST, address, order);
    }

}
