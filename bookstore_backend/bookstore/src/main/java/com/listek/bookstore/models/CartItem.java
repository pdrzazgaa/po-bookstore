package com.listek.bookstore.models;

import jakarta.persistence.*;

@Table(name="PozycjeKoszyka")
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="ilosc")
    private int quantity;
    @ManyToOne
    @JoinColumn(name="ProductID")
    private Product product;
    @ManyToOne
    @JoinColumn(name="KoszykID")
    private Cart cart;

    public CartItem(Long id, int quantity, Product product, Cart cart) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    public CartItem(Product product, Cart cart) {
        this.product = product;
        this.cart = cart;
        this.quantity = 1;
    }

    public CartItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean increase(){
        if (product.decreaseNumberOfItemsInStock()) {
            this.quantity++;
            return true;
        }
        return false;
    }
}
