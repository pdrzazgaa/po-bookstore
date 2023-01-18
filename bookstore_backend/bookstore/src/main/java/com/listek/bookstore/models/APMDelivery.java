package com.listek.bookstore.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="DostawyPaczkomatem")
@Entity
public class APMDelivery extends Delivery {

    private static final double APMDELIVERYCOST = 9.99;

    @Column(name = "numerPaczkomatu")
    private String APMNumber;

    public APMDelivery(Address address, String APMNumber, Order order) {
        super(APMDELIVERYCOST, address, order);
        this.APMNumber = APMNumber;
    }

}
