package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
@Entity
public abstract class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="koszt")
    private double cost;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ZamowienieID")
    private Order order;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AdresID")
    private Address address;

    public Delivery(double cost, Address address, Order order) {
        this.cost = cost;
        this.address = address;
        this.order = order;
    }

}
