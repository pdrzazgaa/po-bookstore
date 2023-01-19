package com.listek.bookstore.controllers;

import com.listek.bookstore.DTO.ProductListDTO;
import com.listek.bookstore.models.Book;
import com.listek.bookstore.repositories.BookRepository;
import com.listek.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    BookService bookService;

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductListDTO> getProducts(){
       return bookService.getProducts();
    }

    @GetMapping("/products/{idK}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductListDTO> getProductsByCategory(@PathVariable int idK){
        return bookService.getProductsByCategory(idK);
    }

    //@GetMapping("/product/{idP}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getProduct(@PathVariable int idP){
        return bookService.getProduct(idP);
    }

    @GetMapping("/product/{idP}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getProductOptimized(@PathVariable int idP){
        return bookService.getProductOptimized(idP);
    }

}
