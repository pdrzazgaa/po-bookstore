package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Table(name="Paragony")
@Entity
public class Receipt extends Document{
    public Receipt(LocalDateTime dateOfIssue, Order order) {
        super(dateOfIssue, order);
    }
}
