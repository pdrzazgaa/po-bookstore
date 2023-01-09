package com.listek.bookstore.models;

import jakarta.persistence.*;

@Entity
@Table(name="Konto Uzytkownika")
public class UserAccount {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="imie")
    private String firstname;
    @Column(name="nazwisko")
    private String surname;
    @Column(name="e_mail")
    private String email;
    @Column(name="telefon")
    private String phoneNumber;
    @Column(name="haslo")
    private String password;

    public UserAccount(Long id, String firstname, String surname, String email, String phoneNumber, String password) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public UserAccount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
