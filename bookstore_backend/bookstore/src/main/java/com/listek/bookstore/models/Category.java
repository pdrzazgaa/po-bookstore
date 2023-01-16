package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name="Kategorie")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="Nazwa")
    private String name;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE,
            mappedBy = "categories")
    private List<Product> products;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="kategoriaNadrzedna")
    private Category parentCategory;

    @JsonInclude
    @OneToMany(mappedBy = "parentCategory")
    private List<Category> children;


    public Category(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
        this.products = new ArrayList<>();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
}
