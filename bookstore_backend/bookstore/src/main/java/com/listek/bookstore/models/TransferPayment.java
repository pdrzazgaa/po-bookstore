package com.listek.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name="PlatnoscPrzelewem")
@Entity
public class TransferPayment extends Payment{
    @Column(name="NumerKonta")
    private String accountNumber;

    public TransferPayment(LocalDateTime paymentDate, String accountNumber, Order order) {
        super(paymentDate, order);
        this.accountNumber = accountNumber;
    }
}
