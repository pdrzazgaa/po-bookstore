package com.listek.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Faktury")
@Entity
public class Invoice extends Document{

    @Column(name="NumerFaktury")
    private String invoiceNumber;

    public Invoice(LocalDateTime dateOfIssue, String invoiceNumber, Order order) {
        super(dateOfIssue, order);
        this.invoiceNumber = invoiceNumber;
    }

    public Invoice() {

    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
