package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Table(name="Koszyki")
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    public Cart(Long id) {
        this.id = id;
    }

    public Cart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
