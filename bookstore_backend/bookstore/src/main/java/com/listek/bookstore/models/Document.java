package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Dokumenty")
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="DataWystawienia")
    private LocalDateTime dateOfIssue;
    @JoinColumn(name = "ZamowienieID")
    @OneToOne
    private Order order;

    public Document(LocalDateTime dateOfIssue, Order order) {
        this.dateOfIssue = dateOfIssue;
        this.order = order;
    }
}
