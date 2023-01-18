package com.listek.bookstore.services;

import com.listek.bookstore.DTO.CartDTO;
import com.listek.bookstore.DTO.CartItemProductDTO;
import com.listek.bookstore.models.Cart;
import com.listek.bookstore.models.CartItem;
import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.Product;
import com.listek.bookstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

    public ResponseEntity getCartOptimized(int clientID) {
        Optional<Object[]> cartObj = cartRepository.isAvailableCartOptimized(Long.valueOf(clientID));
        return cartObj
                .map(foundCartObj -> {
                    if (foundCartObj.length > 0) {
                        CartDTO cartDTO = new CartDTO(foundCartObj);
                        List<CartItemProductDTO> cartItemProductDTOS = new ArrayList<>();
                        List<Object[]> cartItemsObj = cartItemRepository.getCartItemsByCartId(cartDTO.getId());
                        for (Object[] cartItemObj : cartItemsObj) {
                            cartItemProductDTOS.add(new CartItemProductDTO(cartItemObj));
                        }
                        cartDTO.setCartItems(cartItemProductDTOS);
                        cartDTO.computeSumCart();
                        System.out.println("Cart found.");
                        return new ResponseEntity(cartDTO, HttpStatus.OK);
                    } else {
                        System.out.println("Cart not found.");
                        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                    }
                })
                .orElseGet(() -> {
                    System.out.println("Cart not found.");
                    return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                });
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
                                                return ResponseEntity.ok(HttpStatus.OK);
                                            } else {
                                                System.out.println("Cart exists. Not enough products.");
                                                return ResponseEntity.ok(HttpStatus.NO_CONTENT);
                                            }
                                        })
                                        .orElseGet(() -> {
                                            Cart newCart = new Cart(foundClient);
                                            CartItem cartItem = newCart.addProductItem(foundProduct);
                                            if (cartItem != null) {
                                                cartItemRepository.save(cartItem);
                                                cartRepository.save(newCart);
                                                System.out.println("Cart does not exists. Added product.");
                                                return ResponseEntity.ok(HttpStatus.OK);
                                            } else {
                                                System.out.println("Cart does not exists. Not enough products.");
                                                return ResponseEntity.ok(HttpStatus.NO_CONTENT);
                                            }
                                        });
                            })
                            .orElseGet(() -> {
                                System.out.println("Product not found.");
                                return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                            });
                })
                .orElseGet(() -> {
                    System.out.println("Client not found.");
                    return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                });
    }


    @Transactional
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
                                            CartItem foundCartItem = foundCart.removeProductItem(foundProduct);
                                            if (foundCartItem != null) {
                                                cartItemRepository.save(foundCartItem);
                                                productRepository.save(foundProduct);
                                                cartRepository.save(foundCart);
                                                cartItemRepository.removeEmptyCartItem();
                                                cartRepository.removeEmptyCart();
                                                System.out.println("Cart found. Product removed.");
                                                return ResponseEntity.ok(HttpStatus.OK);
                                            } else {
                                                System.out.println("Cart found. Product not removed.");
                                                return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                                            }

                                        })
                                        .orElseGet(() -> {
                                            System.out.println("Cart not found.");
                                            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                                        });
                            })
                            .orElseGet(() -> {
                                System.out.println("Product not found.");
                                return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                            });
                })
                .orElseGet(()-> {
                    System.out.println("Client not found.");
                    return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                });
    }
}
