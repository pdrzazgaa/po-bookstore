package com.listek.bookstore.services;

import com.listek.bookstore.models.Cart;
import com.listek.bookstore.models.CartItem;
import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.Product;
import com.listek.bookstore.repositories.CartItemRepository;
import com.listek.bookstore.repositories.CartRepository;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    private Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCart(int clientID){
        return cartRepository.isAvailableCart(Long.valueOf(clientID));
    }

    public ResponseEntity addItemToCart(Long clientID, Long productID) {
        Optional<Client> client = clientRepository.findClientById(clientID);
        return client
                .map(foundClient -> {
                    Optional<Product> product = productRepository.findById(productID);
                    return product
                            .map(foundProduct -> {
                                Optional<Cart> cart = cartRepository.isAvailableCart(clientID);
                                return cart
                                        .map(foundCart -> {
                                            CartItem cartItem = foundCart.addProductItem(foundProduct);
                                            if (cartItem != null) {
                                                cartItemRepository.save(cartItem);
                                                cartRepository.save(foundCart);
                                                System.out.println("Cart exists. Added product.");
                                                return new ResponseEntity<>(HttpStatus.OK);
                                            } else {
                                                System.out.println("Cart exists. Not enough products.");
                                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                            }
                                        })
                                        .orElseGet(() -> {
                                            Cart newCart = new Cart(foundClient);
                                            CartItem cartItem = newCart.addProductItem(foundProduct);
                                            if (cartItem != null) {
                                                cartItemRepository.save(cartItem);
                                                cartRepository.save(newCart);
                                                System.out.println("Cart does not exists. Added product.");
                                                return new ResponseEntity<>(HttpStatus.OK);
                                            } else {
                                                System.out.println("Cart does not exists. Not enough products.");
                                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                            }
                                        });
                            })
                            .orElseGet(() -> {
                                System.out.println("Product not found.");
                                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                            });
                })
                .orElseGet(() -> {
                    System.out.println("Client not found.");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }


    public ResponseEntity removeCartItem(Long clientID, Long productID){
        Optional<Client> client = clientRepository.findClientById(clientID);
        return client
                .map(foundClient -> {
                    Optional<Product> product = productRepository.findById(productID);
                    return product
                            .map(foundProduct -> {
                                Optional<Cart> cart = cartRepository.isAvailableCart(clientID);
                                return cart
                                        .map(foundCart -> {
                                            if (foundCart.removeProductItem(foundProduct)) {
                                                System.out.println("Cart found. Product removed.");
                                                return new ResponseEntity(HttpStatus.OK);
                                            } else {
                                                System.out.println("Cart found. Product not removed.");
                                                return new ResponseEntity(HttpStatus.NOT_FOUND);
                                            }

                                        })
                                        .orElseGet(() -> {
                                            System.out.println("Cart not found.");
                                            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                                        });
                            })
                            .orElseGet(() -> {
                                System.out.println("Product not found.");
                                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                            });
                })
                .orElseGet(()-> {
                    System.out.println("Client not found.");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }
}
