package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name="HistorieZamowien")
@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name="KlientID")
    private Client client;
    @OneToMany(mappedBy = "orderHistory")
    private ArrayList<Order> orders;


    public OrderHistory(Long id) {
        this.id = id;
    }

    public OrderHistory() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
