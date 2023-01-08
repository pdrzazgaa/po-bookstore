package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class Document {

    private long id;
    private LocalDateTime dateOfIssue;

    public Document(long id, LocalDateTime dateOfIssue) {
        this.id = id;
        this.dateOfIssue = dateOfIssue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
