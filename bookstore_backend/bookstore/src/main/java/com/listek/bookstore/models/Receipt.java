package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class Receipt extends Document{
    public Receipt(Long id, LocalDateTime dateOfIssue) {
        super(id, dateOfIssue);
    }
}
