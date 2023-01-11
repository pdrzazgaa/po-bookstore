package com.listek.bookstore.models;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Receipt extends Document{
    public Receipt(Long id, LocalDateTime dateOfIssue) {
        super(id, dateOfIssue);
    }

    public Receipt() {

    }
}
