package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class OnlinePayment extends Payment{

    public OnlinePayment(Long id, LocalDateTime paymentDate) {
        super(id, paymentDate);
    }
}
