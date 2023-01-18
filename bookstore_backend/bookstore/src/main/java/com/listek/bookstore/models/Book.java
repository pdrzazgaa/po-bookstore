package com.listek.bookstore.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name="Ksiazki")
@Entity
public class Book extends Product{

    @Column(name="Tytul")
    private String title;
    @Column(name="Autor")
    private String author;
    @Column(name="Wydawca")
    private String publisher;
    @Column(name="DataWydania")
    private LocalDateTime releaseDate;
    @Column(name="LiczbaStron")
    private int numberOfPages;
    @Column(name="Jezyk")
    private String language;
    @Column(name="indeks")
    private String index;
    @Column(name="TypOkladki")
    private CoverType coverType;

    public Book(double price, int numberOfItemsInStock, String name, String description, String title,
                String author, String publisher, LocalDateTime releaseDate, int numberOfPages,
                String language, String index, CoverType coverType) {
        super(price, numberOfItemsInStock, name, description);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.index = index;
        this.coverType = coverType;
    }
}
