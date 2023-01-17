package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
}
