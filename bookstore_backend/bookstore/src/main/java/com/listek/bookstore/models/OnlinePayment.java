package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="PlatnosciOnline")
@Entity
public class OnlinePayment extends Payment{

    public OnlinePayment(LocalDateTime paymentDate, Order order) {
        super(paymentDate, order);
    }

    public OnlinePayment() {

    }
}
