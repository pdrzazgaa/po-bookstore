package com.listek.bookstore.DTO;

import com.listek.bookstore.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    // imie, nazwisko, mail, telefon, adres{}, sposobDostawy, sposobPlatnosci, bookcoiny, idK,
    private Long cartID;
    private String forname;
    private String surname;
    private String NIP;
    private String companyName;
    private String mail;
    private String phoneNumber;
    private DocumentDTO documentDTO;
    private AddressDTO addressDTO;
    private DeliveryDTO deliveryDTO;
    private PaymentDTO paymentDTO;
    private int bookcoins;

}
