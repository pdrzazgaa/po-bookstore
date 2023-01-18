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
    @OneToMany(mappedBy = "cart", cascade= CascadeType.ALL)
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

    /**
     * Function adds a product to the cart. If product item with the product exists in the cart,
     * quantity of items increases. If not, new CartItem is added to the cart.
     * Function updates number of items in stock.
     * @param product
     * @return
     */
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

    /**
     * Function removes Product Item from the cart and return a cartItem, which the product was in.
     * If there was no product in the cart, function return null.
     * Function updates number of items in stock.
     * @param product
     * @return
     */

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

    /**
     * Function checks if there is a product in the cart
     * @param product
     * @return
     */

    private CartItem isProductInCart(Product product) {
        for (CartItem cartItem : this.cartItems) {
            if (cartItem.getProduct().equals(product)) {
                return cartItem;
            }
        }
        return null;
    }

    /**
     * Function computes sum of the cart and saves it to its property.
     */

    public void computeSumCart(){
        double sum = 0;
        for (CartItem cartItem:this.cartItems){
            sum += cartItem.getCosts();
        }
        this.cartSum = sum;
    }
}
