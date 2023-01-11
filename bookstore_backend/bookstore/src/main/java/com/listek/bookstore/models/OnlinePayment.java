package com.listek.bookstore.models;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class OnlinePayment extends Payment{

    public OnlinePayment(Long id, LocalDateTime paymentDate) {
        super(id, paymentDate);
    }

    public OnlinePayment() {

    }
}
