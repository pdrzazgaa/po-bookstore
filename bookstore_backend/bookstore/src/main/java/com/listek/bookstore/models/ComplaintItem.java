package com.listek.bookstore.models;

public class ComplaintItem {

    private long id;
    private Product product;
    private String complaintReason;
    private int quantity;

    public ComplaintItem(long id, Product product, String complaintReason, int quantity) {
        this.id = id;
        this.product = product;
        this.complaintReason = complaintReason;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
