package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Table(name="Reklamacje")
@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="DataReklamacji")
    private LocalDateTime complaintDate;
    @Column(name="NumerKonta")
    private String accountNumber;
    @Column(name="StatusReklamacji")
    private ComplaintStatus complaintStatus;
    @OneToOne
    @JoinColumn(name="ZamowienieID")
    private Order order;
    @OneToMany(mappedBy="complaint")
    private ArrayList<ComplaintItem> complaintItems;

    public Complaint(Long id, LocalDateTime complaintDate, String accountNumber, ComplaintStatus complaintStatus, Order order, ArrayList<ComplaintItem> complaintItems) {
        this.id = id;
        this.complaintDate = complaintDate;
        this.accountNumber = accountNumber;
        this.complaintStatus = complaintStatus;
        this.order = order;
        this.complaintItems = complaintItems;
    }

    public Complaint() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDateTime complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<ComplaintItem> getComplaintItems() {
        return complaintItems;
    }

    public void setComplaintItems(ArrayList<ComplaintItem> complaintItems) {
        this.complaintItems = complaintItems;
    }
}
