package com.listek.bookstore.controllers;

import com.listek.bookstore.fromToModels.ProductListToData;
import com.listek.bookstore.models.Order;
import com.listek.bookstore.repositories.BookRepository;
import com.listek.bookstore.repositories.ProductRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductListToData> getProducts(){
        System.out.println("Get products");
        List<Object[]> books = bookRepository.findBooks();
        List<ProductListToData> booksToData = new ArrayList<>();
        for (Object[] bookObj:books){
            booksToData.add(new ProductListToData(bookObj));
        }
        return booksToData;
    }

    @GetMapping("/products/{idK}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ProductListToData> getProductsByCategory(@PathVariable int idK){
        System.out.println("Get products by category");
        List<Object[]> books = bookRepository.findBooksByCategory(Long.valueOf(idK));
        List<ProductListToData> booksToData = new ArrayList<>();
        for (Object[] bookObj:books){
            booksToData.add(new ProductListToData(bookObj));
        }
        return booksToData;
    }

}
