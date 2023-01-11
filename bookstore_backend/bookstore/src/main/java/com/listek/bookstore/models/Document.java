package com.listek.bookstore.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Dokumenty")
@Entity
public class Document {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="dataWystawienia")
    private LocalDateTime dateOfIssue;

    public Document(Long id, LocalDateTime dateOfIssue) {
        this.id = id;
        this.dateOfIssue = dateOfIssue;
    }

    public Document() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
