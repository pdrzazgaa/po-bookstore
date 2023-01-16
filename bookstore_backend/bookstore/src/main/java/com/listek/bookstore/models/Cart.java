package com.listek.bookstore.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="Koszyki")
@Entity
public class Cart {
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

    public Cart(Client client) {
        this.client = client;
        cartItems = new ArrayList<>();
    }

    public Cart() {

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

    public boolean addProductItem(Product product) {
        CartItem foundCartItem = isProductInCart(product);

        if (foundCartItem == null) {
            if (product.decreaseNumberOfItemsInStock()) {
                this.cartItems.add(new CartItem(product, this));
                return true;
            }
            return false;
        } else {
            return foundCartItem.increase();
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
}
