package com.listek.bookstore.models;

import jakarta.persistence.*;

@Table(name="Kategorie")
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="Nazwa")
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
