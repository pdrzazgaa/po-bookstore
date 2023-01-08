package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class Payment {

    private long id;
    private LocalDateTime paymentDate;

    public Payment(long id, LocalDateTime paymentDate) {
        this.id = id;
        this.paymentDate = paymentDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}
