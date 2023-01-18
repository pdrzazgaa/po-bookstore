package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="Adresy")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="imie")
    private String firstname;
    @Column(name="nazwisko")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(name="numerTelefonu")
    private String phoneNumber;
    @Column(name="Ulica")
    private String street;
    @Column(name="NumerMieszkania")
    private String number;
    @Column(name="KodPocztowy")
    private String postCode;
    @Column(name="Miejscowosc")
    private String town;
    @Column(name="Kraj")
    private String country;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="KlientID")
    private Client client;

    public Address(String firstname, String surname, String email, String phoneNumber, String street,
                   String number, String postCode, String town, String country) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.number = number;
        this.postCode = postCode;
        this.town = town;
        this.country = country;
    }

}
