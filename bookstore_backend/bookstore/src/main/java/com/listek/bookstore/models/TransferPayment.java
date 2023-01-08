package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class TransferPayment extends Payment{
    private String accountNumber;

    public TransferPayment(long id, LocalDateTime paymentDate, String accountNumber) {
        super(id, paymentDate);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
