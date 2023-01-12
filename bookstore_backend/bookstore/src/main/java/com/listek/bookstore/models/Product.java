package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.ArrayList;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Produkty")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="Cena")
    private float price;
    @Column(name="LiczbaSztukNaStanie")
    private int numberOfItemsInStock;
    @Column(name="Nazwa")
    private String name;
    @Column(name="Opis")
    private String description;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "products")
    private ArrayList<Category> categories;

    public Product(Long id, float price, int numberOfItemsInStock, String name, String description, ArrayList<Category> category) {
        this.id = id;
        this.price = price;
        this.numberOfItemsInStock = numberOfItemsInStock;
        this.name = name;
        this.description = description;
        this.categories = category;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberOfItemsInStock() {
        return numberOfItemsInStock;
    }

    public void setNumberOfItemsInStock(int numberOfItemsInStock) {
        this.numberOfItemsInStock = numberOfItemsInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Category> getCategory() {
        return categories;
    }

    public void setCategory(ArrayList<Category> category) {
        this.categories = category;
    }
}
