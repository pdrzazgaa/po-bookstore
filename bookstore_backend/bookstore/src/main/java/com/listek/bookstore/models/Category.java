package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

}
