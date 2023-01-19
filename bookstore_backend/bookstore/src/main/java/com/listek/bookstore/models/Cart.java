package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.listek.bookstore.repositories.CartItemRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Table(name="Koszyki")
@JsonIgnoreProperties({"client"})
@Entity
public class Cart {

    public static final int EXPIRATION_TIME = 15;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "OstatniaAktywnosc")
    private LocalDateTime lastActivity;
    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KlientID")
    private Client client;
    @JsonInclude
    @Transient
    private double cartSum;

    public Cart(Client client) {
        this.client = client;
        cartItems = new ArrayList<>();
        lastActivity = LocalDateTime.now();
    }

    public Cart() {
        lastActivity = LocalDateTime.now();
    }

    public CartItem addProductItem(Product product) {
        CartItem foundCartItem = isProductInCart(product);
        CartItem newCartItem;

        if (foundCartItem == null) {
            if (product.decreaseNumberOfItemsInStock()) {
                lastActivity = LocalDateTime.now();
                newCartItem = new CartItem(product, this);
                this.cartItems.add(newCartItem);
                computeSumCart();
                return newCartItem;
            }
            return null;
        } else {
            if (foundCartItem.increase())
                return foundCartItem;
            else
                return null;
        }
    }

    public CartItem removeProductItem(Product product){
        CartItem foundCartItem = isProductInCart(product);

        if (foundCartItem != null) {
            product.increaseNumberOfItemsInStock();
            lastActivity = LocalDateTime.now();
            foundCartItem.decrease();
            computeSumCart();
            if (foundCartItem.getQuantity() == 0)
                this.cartItems.remove(foundCartItem);
            return foundCartItem;
        } else {
            return null;
        }
    }

    private CartItem isProductInCart(Product product) {
        for (CartItem cartItem : this.cartItems) {
            if (cartItem.getProduct().getId().longValue() == product.getId().longValue()) {
                return cartItem;
            }
        }
        return null;
    }
    public void computeSumCart(){
        double sum = 0;
        for (CartItem cartItem:this.cartItems){
            sum += cartItem.getCosts();
        }
        this.cartSum = sum;
    }
}
