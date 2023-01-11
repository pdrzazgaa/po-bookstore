package com.listek.bookstore.models;

import jakarta.persistence.*;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Produkty")
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private float price;
    private int numberOfItemsInStock;
    private String name;
    private String description;
    private String photoURL;

    public Product(Long id, float price, int numberOfItemsInStock, String name,
                   String description, String photoURL) {
        this.id = id;
        this.price = price;
        this.numberOfItemsInStock = numberOfItemsInStock;
        this.name = name;
        this.description = description;
        this.photoURL = photoURL;
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

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
