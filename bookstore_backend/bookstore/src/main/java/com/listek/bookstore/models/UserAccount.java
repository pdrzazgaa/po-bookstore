package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="KontaUzytkownika")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public UserAccount(String firstname, String surname, String email, String phoneNumber, String password) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}
