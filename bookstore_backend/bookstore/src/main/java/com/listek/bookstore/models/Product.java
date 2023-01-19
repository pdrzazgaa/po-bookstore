package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
@JsonIgnoreProperties(value = { "category" })
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
    @Column(name="Opis", length=2000)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
    @JoinTable(
            name = "ProduktyKategorie",
            joinColumns = { @JoinColumn(name = "ProduktID") },
            inverseJoinColumns = { @JoinColumn(name = "KategoriaID") }
    )
    private List<Category> categories;

    public Product(Long id) {
        this.id = id;
        this.categories = new ArrayList<>();
    }

    public Product(double price, int numberOfItemsInStock, String name, String description) {
        this.price = price;
        this.numberOfItemsInStock = numberOfItemsInStock;
        this.name = name;
        this.description = description;
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category){
        if (category != null) {
            if (!this.categories.contains(category)) {
                this.categories.add(category);
                this.categories.add(category.getParentCategory());
            }
        }
    }

    public boolean decreaseNumberOfItemsInStock(){
        if (this.numberOfItemsInStock > 0) {
            this.numberOfItemsInStock--;
            return true;
        }
        return false;
    }

    public void increaseNumberOfItemsInStock(){
        this.numberOfItemsInStock++;
    }


}
