package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Produkty")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="Cena")
    private double price;
    @Column(name="LiczbaSztukNaStanie")
    private int numberOfItemsInStock;
    @Column(name="Nazwa")
    private String name;
    @Column(name="Opis")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JoinTable(
            name = "ProduktyKategorie",
            joinColumns = { @JoinColumn(name = "ProduktID") },
            inverseJoinColumns = { @JoinColumn(name = "KategoriaID") }
    )
    private List<Category> categories;

    public Product(Long id, double price, int numberOfItemsInStock, String name, String description, List<Category> category) {
        this.id = id;
        this.price = price;
        this.numberOfItemsInStock = numberOfItemsInStock;
        this.name = name;
        this.description = description;
        this.categories = category;
    }

    public Product(double price, int numberOfItemsInStock, String name, String description) {
        this.price = price;
        this.numberOfItemsInStock = numberOfItemsInStock;
        this.name = name;
        this.description = description;
        this.categories = new ArrayList<>();
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

    public List<Category> getCategory() {
        return categories;
    }

    public void setCategory(List<Category> category) {
        this.categories = category;
    }

    public void addCategory(Category category){
        if (category != null) {
            if (!this.categories.contains(category)) {
                this.categories.add(category);
                category.addProduct(this);
                this.categories.add(category.getParentCategory());
            }
        }
    }


}
