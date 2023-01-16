package com.listek.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="FakturyFirmy")
@Entity
public class CompanyInvoice extends Invoice {
    @Column
    private int NIP;
    @Column(name="NazwaFirmy")
    private String companyName;

    public CompanyInvoice(Long id, LocalDateTime dateOfIssue, String invoiceNumber, int NIP, String companyName) {
        super(id, dateOfIssue, invoiceNumber);
        this.NIP = NIP;
        this.companyName = companyName;
    }

    public CompanyInvoice() {
        super(Long.valueOf(0), LocalDateTime.now(), "0/0");
    }


    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
