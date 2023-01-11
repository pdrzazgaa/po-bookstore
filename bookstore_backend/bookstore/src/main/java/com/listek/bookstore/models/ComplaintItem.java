package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name="PozycjeReklamacji")
@Entity
public class ComplaintItem {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "PowodReklamacji")
    private String complaintReason;
    @Column(name = "ilosc")
    private int quantity;
    @OneToOne
    @JoinColumn(name ="ProduktID", nullable = false)
    private Product products;


    public ComplaintItem(Long id, String complaintReason, int quantity) {
        this.id = id;
        this.complaintReason = complaintReason;
        this.quantity = quantity;
    }

    public ComplaintItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplaintReason() {
        return complaintReason;
    }

    public void setComplaintReason(String complaintReason) {
        this.complaintReason = complaintReason;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
