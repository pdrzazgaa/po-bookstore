package com.listek.bookstore.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name="Zamowienia")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="DataZlozeniaZamowienia")
    private LocalDateTime date;
    @Column(name="Rabat")
    private int discount;
    @Column(name="StatusZamowienia")
    private OrderStatus orderStatus;
    @Column(name="NumerZamowienia")
    private String orderNumber;
    @OneToOne
    @JoinColumn(name="KoszykID")
    private Cart cart;
    @OneToOne(mappedBy = "order")
    private Document document;
    @OneToOne(mappedBy = "order")
    private Payment payment;
    @OneToOne(mappedBy = "order")
    private Delivery delivery;
    @OneToOne(mappedBy = "order")
    private Complaint complaint;
    @ManyToOne
    @JoinColumn(name="HistoriaZamowienID")
    private OrderHistory orderHistory;


    public Order(Long id, LocalDateTime date, int discount, OrderStatus orderStatus, String orderNumber, Cart cart, Document document, Payment payment, Delivery delivery, Complaint complaint, OrderHistory orderHistory) {
        this.id = id;
        this.date = date;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.cart = cart;
        this.document = document;
        this.payment = payment;
        this.delivery = delivery;
        this.complaint = complaint;
        this.orderHistory = orderHistory;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }
}
