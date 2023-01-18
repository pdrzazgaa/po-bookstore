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
    private Long cartId;
    private String forname;
    private String surname;
    private String nip;
    private String companyName;
    private String mail;
    private String phoneNumber;
    private String document;
    private AddressDTO address;
    private DeliveryDTO delivery;
    private String payment;
    private int bookcoins;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "cartId=" + cartId +
                ", forname='" + forname + '\'' +
                ", surname='" + surname + '\'' +
                ", NIP='" + nip + '\'' +
                ", companyName='" + companyName + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", document='" + document + '\'' +
                ", address=" + address +
                ", delivery=" + delivery +
                ", payment='" + payment + '\'' +
                ", bookcoins=" + bookcoins +
                '}';
    }
}
