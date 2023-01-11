package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="Paragony")
@Entity
public class Receipt extends Document{
    public Receipt(Long id, LocalDateTime dateOfIssue) {
        super(id, dateOfIssue);
    }

    public Receipt() {

    }
}
