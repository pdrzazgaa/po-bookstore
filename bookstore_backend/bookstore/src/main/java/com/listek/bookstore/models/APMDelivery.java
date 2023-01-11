package com.listek.bookstore.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name="DostawyPaczkomatem")
@Entity
public class APMDelivery extends Delivery{

    @Column(name="numerPaczkomatu")
    private String APMNumber;

    public APMDelivery(Long id, float cost, Address address, String APMNumber) {
        super(id, cost, address);
        this.APMNumber = APMNumber;
    }

    public APMDelivery() {

    }

    public String getAPMNumber() {
        return APMNumber;
    }

    public void setAPMNumber(String APMNumber) {
        this.APMNumber = APMNumber;
    }
}
