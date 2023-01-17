package com.listek.bookstore.DTO;

import com.listek.bookstore.models.Address;
import com.listek.bookstore.models.Delivery;
import com.listek.bookstore.models.Order;
import com.listek.bookstore.models.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    // imie, nazwisko, mail, telefon, adres{}, sposobDostawy, sposobPlatnosci, bookcoiny, idK,
    private Long clientID;
    private Address address;
    private String NIP;
    private String companyName;
    private Delivery delivery;
    private Payment payment;
    private int bookCoins;


    public Order fromOrderDTOtoOrder(){
        Order order = new Order();

        order.setPayment(this.payment);
        order.setDelivery(this.delivery);

        return order;
    }
}
