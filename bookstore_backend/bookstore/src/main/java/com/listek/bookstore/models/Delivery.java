package com.listek.bookstore.models;

import jakarta.persistence.*;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Dostawy")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    private float cost;

    public Delivery(Long id, float cost, Address address) {
        this.id = id;
        this.cost = cost;
    }

    public Delivery() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}
