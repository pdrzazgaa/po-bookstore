package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.List;

@Table(name="Klienci")
@Entity
public class Client extends UserAccount{

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Address> addresses;
    @OneToOne(mappedBy = "client", cascade = CascadeType.MERGE)
    private OrderHistory orderHistory;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private LoyaltyProgram loyaltyProgram;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Cart> carts;

    public Client(String firstname, String surname, String email, String phoneNumber, String password) {
        super(firstname, surname, email, phoneNumber, password);
    }

    public Client() {

    }

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }


    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public List<Cart> getCarts() {
        return carts;
    }
}
