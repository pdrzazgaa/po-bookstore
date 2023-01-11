package com.listek.bookstore.models;

import jakarta.persistence.*;

@Table(name="Katalog")
@Entity
public class Catalog {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="nazwa")
    private String name;

    public Catalog(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Catalog() {

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
