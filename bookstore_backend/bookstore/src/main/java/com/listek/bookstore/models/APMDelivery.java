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

    @Column(name = "numerPaczkomatu")
    private String APMNumber;

    public APMDelivery(double cost, Address address, String APMNumber, Order order) {
        super(cost, address, order);
        this.APMNumber = APMNumber;
    }

}
