package com.listek.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Faktury")
@Entity
public class Invoice extends Document{

    @Column(name="NumerFaktury")
    private String invoiceNumber;

    public Invoice(LocalDateTime dateOfIssue, Order order) {
        super(dateOfIssue, order);
        generateInvoiceNumber();
    }

    protected void generateInvoiceNumber(){
        this.invoiceNumber =  (int)(Math.random() * 1000) +"/2023";
    }

}
