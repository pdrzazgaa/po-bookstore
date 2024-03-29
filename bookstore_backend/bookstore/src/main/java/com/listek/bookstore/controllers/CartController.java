package com.listek.bookstore.controllers;

import com.listek.bookstore.DTO.CartDTO;
import com.listek.bookstore.DTO.CartItemDTO;
import com.listek.bookstore.models.Cart;
import com.listek.bookstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //@GetMapping("/cart/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getCart(@PathVariable int id) {
        Optional<Cart> cart = cartService.getCart(id);
        return cart
                .map(foundCart -> {
                    foundCart.computeSumCart();
                    System.out.println("Cart found.");
                    return new ResponseEntity<>(cart, HttpStatus.OK);
                })
                .orElseGet(()->{
                    System.out.println("Cart not found.");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    /**
     * Optimized function of getting cart.
     * @param id
     * @return
     */


    @GetMapping("/cart/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getCartOptimized(@PathVariable int id) {
        CartDTO cartDTO = cartService.getCartOptimized(id);
        if (cartDTO != null)
            return new ResponseEntity(cartDTO, HttpStatus.OK);
        else
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCartItem")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        return cartService.addItemToCart(cartItemDTO.getClientID(), cartItemDTO.getProductID());
    }

    //@PostMapping("/addCartItem")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity addCartItemOptimized(@RequestBody CartItemDTO cartItemDTO) {
        return cartService.addItemToCartOptimized(cartItemDTO.getClientID(), cartItemDTO.getProductID());
    }

    @PostMapping("/removeCartItem")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity removeCartItem(@RequestBody CartItemDTO cartItemDTO) {
        return cartService.removeCartItem(cartItemDTO.getClientID(), cartItemDTO.getProductID());
    }
}
