package com.listek.bookstore.controllers;

import com.listek.bookstore.fromToModels.ProductListDTO;
import com.listek.bookstore.models.Book;
import com.listek.bookstore.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductListDTO> getProducts(){
        System.out.println("Get products");
        List<Object[]> books = bookRepository.findBooks();
        List<ProductListDTO> booksToData = new ArrayList<>();
        for (Object[] bookObj:books){
            booksToData.add(new ProductListDTO(bookObj));
        }
        return booksToData;
    }

    @GetMapping("/products/{idK}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductListDTO> getProductsByCategory(@PathVariable int idK){
        System.out.println("Get products by category");
        List<Object[]> books = bookRepository.findBooksByCategory(Long.valueOf(idK));
        List<ProductListDTO> booksToData = new ArrayList<>();
        for (Object[] bookObj:books){
            booksToData.add(new ProductListDTO(bookObj));
        }
        return booksToData;
    }

    @GetMapping("/product/{idP}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getProduct(@PathVariable int idP){
        System.out.println("Get product");
        Optional<Book> book = bookRepository.findById(Long.valueOf(idP));
        return book
                .map(foundBook -> {
                    System.out.println("Book found.");
                    return new ResponseEntity(foundBook, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    System.out.println("Book not found.");
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                });
    }

}
