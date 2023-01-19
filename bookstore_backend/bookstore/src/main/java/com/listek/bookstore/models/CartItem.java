package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name="PozycjeKoszyka")
@JsonIgnoreProperties({"cart", "product.category"})
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

    public CartItem(Product product, Cart cart) {
        this.product = product;
        this.cart = cart;
        this.quantity = 1;
    }

    public boolean increase(){
        if (product.decreaseNumberOfItemsInStock()) {
            this.quantity++;
            return true;
        }
        return false;
    }

    public void decrease(){
        this.quantity--;
    }

    public double getCosts(){
        return this.quantity * this.product.getPrice();
    }
}
