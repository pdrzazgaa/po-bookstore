package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name="Kategorie")
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="Nazwa")
    private String name;
    @ManyToMany(mappedBy = "category")
    private ArrayList<Product> products;

    public Category(Long id, String name, ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Category() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
