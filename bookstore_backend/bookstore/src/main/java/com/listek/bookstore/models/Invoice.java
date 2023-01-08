package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class Invoice extends Document{

    private String invoiceNumber;

    public Invoice(long id, LocalDateTime dateOfIssue, String invoiceNumber) {
        super(id, dateOfIssue);
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
