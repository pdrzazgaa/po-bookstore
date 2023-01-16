package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.listek.bookstore.repositories.CartItemRepository;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="Koszyki")
@JsonIgnoreProperties("client")
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
    @ManyToOne
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LocalDateTime lastActivity) {
        this.lastActivity = lastActivity;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getCartSum() {
        return cartSum;
    }

    public void setCartSum(double cartSum) {
        this.cartSum = cartSum;
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

    public boolean removeProductItem(Product product){
        CartItem foundCartItem = isProductInCart(product);

        if (foundCartItem != null) {
            product.increaseNumberOfItemsInStock();
            lastActivity = LocalDateTime.now();
            foundCartItem.decrease();
            computeSumCart();
            if (foundCartItem.getQuantity() == 0)
                this.cartItems.remove(foundCartItem);
            return true;
        } else {
            return false;
        }
    }

    private CartItem isProductInCart(Product product) {
        for (CartItem cartItem : this.cartItems) {
            if (cartItem.getProduct().equals(product)) {
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
