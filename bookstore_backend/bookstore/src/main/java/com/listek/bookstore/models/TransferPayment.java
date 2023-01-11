package com.listek.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="PlatnoscPrzelewem")
@Entity
public class TransferPayment extends Payment{
    @Column(name="NumerKonta")
    private String accountNumber;

    public TransferPayment(Long id, LocalDateTime paymentDate, String accountNumber) {
        super(id, paymentDate);
        this.accountNumber = accountNumber;
    }

    public TransferPayment() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
