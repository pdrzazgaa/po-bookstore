package com.listek.bookstore.models;

public class APMDelivery extends Delivery{

    private String APMNumber;

    public APMDelivery(long id, float cost, Address address, String APMNumber) {
        super(id, cost, address);
        this.APMNumber = APMNumber;
    }

    public String getAPMNumber() {
        return APMNumber;
    }

    public void setAPMNumber(String APMNumber) {
        this.APMNumber = APMNumber;
    }
}
