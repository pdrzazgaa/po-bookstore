package com.listek.bookstore.services;

import com.listek.bookstore.DTO.CartDTO;
import com.listek.bookstore.DTO.CartItemProductDTO;
import com.listek.bookstore.DTO.ProductDetailsDTO;
import com.listek.bookstore.DTO.ProductListDTO;
import com.listek.bookstore.models.*;
import com.listek.bookstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
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
    BookRepository bookRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    private Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCart(int clientID){
        return cartRepository.isAvailableCart(Long.valueOf(clientID));
    }

    public CartDTO getCartOptimized(long clientID) {
        Optional<Object[]> cartObj = cartRepository.isAvailableCartOptimized(clientID);
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
                        return cartDTO;
                    } else {
                        System.out.println("Cart not found.");
                        return null;
                    }

                })
                .orElseGet(()->{
                    System.out.println("Cart not found.");
                    return null;
                });
    }

    @Transactional
    public ResponseEntity addItemToCartOptimized(Long clientID, Long productID) {
        Optional<Client> client = clientRepository.findClientById(clientID);
        return client
                .map(foundClient -> {
                    Optional<Object[]> productObj = bookRepository.findBook(productID);
                    if (productObj.isPresent()) {
                        ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO(productObj.get());
                        if (productDetailsDTO.getId() == 0) {
                            System.out.println("Product not found.");
                            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                        } else {
                            Book product = productDetailsDTO.toBook();
                            CartDTO cartDTO = getCartOptimized(clientID);
                            if (cartDTO != null) {
                                // Cart exists
                                Cart cart = cartDTO.toCart();
                                CartItem cartItem = cart.addProductItem(product);
                                if (cartItem != null) {
                                    productRepository.updateItemsInStock(product.getNumberOfItemsInStock(), productID);
                                    cartRepository.updateLastActivity(cart.getLastActivity(), cart.getId());
                                    cartItemRepository.save(cartItem);
                                    System.out.println("Cart exists. Added product.");
                                    return ResponseEntity.ok(HttpStatus.OK);
                                } else {
                                    System.out.println("Cart exists. Not enough products.");
                                    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
                                }

                            } else {
                                // Creating new cart
                                Cart newCart = new Cart(foundClient);
                                CartItem cartItem = newCart.addProductItem(product);
                                if (cartItem != null) {
                                    productRepository.updateItemsInStock(product.getNumberOfItemsInStock(), productID);
                                    cartRepository.save(newCart);
                                    cartItemRepository.save(cartItem);
                                    System.out.println("Cart does not exists. Added product.");
                                    return ResponseEntity.ok(HttpStatus.OK);
                                } else {
                                    System.out.println("Cart does not exists. Not enough products.");
                                    return ResponseEntity.ok(HttpStatus.NO_CONTENT);
                                }
                            }
                        }
                    }

                    System.out.println("Product not found.");
                    return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                })
                .orElseGet(() -> {
                    System.out.println("Client not found.");
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
                                                cartRepository.save(foundCart);
                                                cartItemRepository.save(cartItem);
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
                                                cartRepository.save(newCart);
                                                cartItemRepository.save(cartItem);
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
