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

    public TransferPayment(Order order) {
        super(order);
        generateAccountNumber();
    }

    private void generateAccountNumber(){
        accountNumber = (Math.random() * 100) +  " ";
        for (int i=0; i<6; i++) accountNumber += accountNumber + (Math.random() * 10000) + " ";
    }
}
