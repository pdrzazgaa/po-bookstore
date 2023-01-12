package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name="Kategorie")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="Nazwa")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "ProduktyKategorie",
            joinColumns = { @JoinColumn(name = "ProduktID") },
            inverseJoinColumns = { @JoinColumn(name = "KategoriaID") }
    )
    private ArrayList<Product> products = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name="kategoriaNadrzedna")
    private Category parentCategory;


    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
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

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
