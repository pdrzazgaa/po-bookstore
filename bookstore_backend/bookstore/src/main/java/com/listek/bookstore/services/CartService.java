package com.listek.bookstore.services;

import com.listek.bookstore.models.Cart;
import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.Product;
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

    private Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public ResponseEntity addItemToCart(Long clientID, Long productID){
        Optional<Client> client = clientRepository.findClientById(clientID);
        return client
                .map(foundClient -> {
                    Optional<Product> product = productRepository.findById(productID);
                    return product
                            .map(foundProduct -> {
                                Optional<Cart> cart = cartRepository.isAvailableCart(clientID);
                                return cart
                                        .map(foundCart -> {
                                            if (foundCart.addProductItem(foundProduct)){
                                                return new ResponseEntity<>(HttpStatus.OK);
                                            } else {
                                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                            }
                                        })
                                        .orElseGet(() -> {
                                            Cart newCart = new Cart();
                                            if (newCart.addProductItem(foundProduct)){
                                                return new ResponseEntity<>(HttpStatus.OK);
                                            } else {
                                                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                                            }
                                        });
                            })
                            .orElseGet(()-> {
                                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                            });
                })
                .orElseGet(()->{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });

    }
}
