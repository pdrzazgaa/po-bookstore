package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
    private List<Order> orders;

    public OrderHistory() {

    }
}
