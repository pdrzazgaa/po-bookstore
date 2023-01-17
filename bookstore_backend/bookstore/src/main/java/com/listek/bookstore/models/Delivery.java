package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@Setter
@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Dostawy")
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="koszt")
    private double cost;
    @OneToOne
    @JoinColumn(name = "ZamowienieID")
    private Order order;
    @OneToOne
    @JoinColumn(name = "AdresID")
    private Address address;

    public Delivery(double cost, Address address, Order order) {
        this.cost = cost;
        this.address = address;
        this.order = order;
    }

    public Delivery() {

    }

}
