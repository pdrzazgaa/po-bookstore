package com.listek.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="Zamowienia")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;
    private int discount;
    private OrderStatus orderStatus;
    private String orderNumber;

    public Order(Long id, LocalDateTime date, int discount, OrderStatus orderStatus, String orderNumber) {
        this.id = id;
        this.date = date;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
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

}
