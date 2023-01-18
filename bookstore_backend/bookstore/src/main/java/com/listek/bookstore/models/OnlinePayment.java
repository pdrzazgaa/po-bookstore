package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name="PlatnosciOnline")
@Entity
public class OnlinePayment extends Payment{

    public OnlinePayment(Order order) {
        super(order);
    }
}
