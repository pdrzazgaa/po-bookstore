package com.listek.bookstore.controllers;

import com.listek.bookstore.repositories.CartRepository;
import com.listek.bookstore.repositories.ClientRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    CartRepository cartRepository;
    ClientRepository clientRepository;

    public CartController(CartRepository cartRepository, ClientRepository clientRepository) {
        this.cartRepository = cartRepository;
        this.clientRepository = clientRepository;
    }


}
