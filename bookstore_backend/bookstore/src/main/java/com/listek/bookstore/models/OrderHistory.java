package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="HistorieZamowien")
@Entity
public class OrderHistory {
    @Id
    @GeneratedValue
    private Long id;

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
