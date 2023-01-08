package com.listek.bookstore.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Complaint {
    private long id;
    private LocalDateTime complaintDate;
    private String accountNumber;
    private ComplaintStatus complaintStatus;
    private ArrayList<ComplaintItem> complaintItems;

    public Complaint(long id, LocalDateTime complaintDate, String accountNumber, ComplaintStatus complaintStatus, ArrayList<ComplaintItem> complaintItems) {
        this.id = id;
        this.complaintDate = complaintDate;
        this.accountNumber = accountNumber;
        this.complaintStatus = complaintStatus;
        this.complaintItems = complaintItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public ArrayList<ComplaintItem> getComplaintItems() {
        return complaintItems;
    }

    public void setComplaintItems(ArrayList<ComplaintItem> complaintItems) {
        this.complaintItems = complaintItems;
    }
}
