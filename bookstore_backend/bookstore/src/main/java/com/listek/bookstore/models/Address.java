package com.listek.bookstore.models;

import jakarta.persistence.*;

@Table(name="Adresy")
@Entity
public class Address {
    @Id
    @GeneratedValue
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

    public Address(Long id, String firstname, String surname, String email, String phoneNumber, String street,
                   String number, String postCode, String town, String country) {
        this.id = id;
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

    public Address() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
