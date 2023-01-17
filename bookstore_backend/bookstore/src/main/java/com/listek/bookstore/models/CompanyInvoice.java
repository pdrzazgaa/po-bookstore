package com.listek.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name="FakturyFirmy")
@Entity
public class CompanyInvoice extends Invoice {
    @Column
    private int NIP;
    @Column(name="NazwaFirmy")
    private String companyName;

    public CompanyInvoice(LocalDateTime dateOfIssue, String invoiceNumber, int NIP, String companyName, Order order) {
        super(dateOfIssue, invoiceNumber, order);
        this.NIP = NIP;
        this.companyName = companyName;
    }
}
