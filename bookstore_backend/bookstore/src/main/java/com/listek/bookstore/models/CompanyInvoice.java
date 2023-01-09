package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class CompanyInvoice extends Invoice {
    private int NIP;
    private String companyName;

    public CompanyInvoice(Long id, LocalDateTime dateOfIssue, String invoiceNumber, int NIP, String companyName) {
        super(id, dateOfIssue, invoiceNumber);
        this.NIP = NIP;
        this.companyName = companyName;
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
