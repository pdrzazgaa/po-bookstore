package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class Document {

    private Long id;
    private LocalDateTime dateOfIssue;

    public Document(Long id, LocalDateTime dateOfIssue) {
        this.id = id;
        this.dateOfIssue = dateOfIssue;
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
