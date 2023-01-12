package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;
import java.util.List;

@Table(name="Klienci")
@Entity
public class Client extends UserAccount{

    @OneToMany(mappedBy = "client")
    private List<Address> addresses;
    @OneToOne(mappedBy = "client")
    private OrderHistory orderHistory;
    @OneToOne(mappedBy = "client")
    private LoyaltyProgram loyaltyProgram;
    @OneToMany(mappedBy = "client")
    private List<Cart> carts;

    public Client(Long id, String firstname, String surname, String email, String phoneNumber, String password, List<Address> addresses, OrderHistory orderHistory, LoyaltyProgram loyaltyProgram, List<Cart> carts) {
        super(id, firstname, surname, email, phoneNumber, password);
        this.addresses = addresses;
        this.orderHistory = orderHistory;
        this.loyaltyProgram = loyaltyProgram;
        this.carts = carts;
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
