package com.listek.bookstore.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }
}
