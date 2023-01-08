package com.listek.bookstore.models;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private LocalDateTime date;
    private int discount;
    private OrderStatus orderStatus;
    private String orderNumber;

    private Payment payment;
    private Delivery delivery;
    private Document document;
    private Cart cart;

    public Order(long id, LocalDateTime date, int discount, OrderStatus orderStatus, String orderNumber, Payment payment, Delivery delivery, Document document, Cart cart) {
        this.id = id;
        this.date = date;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.payment = payment;
        this.delivery = delivery;
        this.document = document;
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
