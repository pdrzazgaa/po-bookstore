package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table(name="HistorieZamowien")
@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="KlientID")
    private Client client;
    @OneToMany(mappedBy = "orderHistory", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
