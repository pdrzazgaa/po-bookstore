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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ProductID")
    private Product product;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="KoszykID")
    private Cart cart;

    public CartItem(Product product, Cart cart) {
        this.product = product;
        this.cart = cart;
        this.quantity = 1;
    }

    /**
     * Function increases number of items in cart if there is more than 1 item in stock
     * @return
     */

    public boolean increase(){
        if (product.decreaseNumberOfItemsInStock()) {
            this.quantity++;
            return true;
        }
        return false;
    }

    /**
     * Function decreases amount of the item in cart
     */

    public void decrease(){
        this.quantity--;
    }

    /**
     * Function return cost of the item (quantity times product's price
     * @return
     */

    public double getCosts(){
        return this.quantity * this.product.getPrice();
    }
}
