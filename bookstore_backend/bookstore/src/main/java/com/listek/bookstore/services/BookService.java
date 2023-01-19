package com.listek.bookstore.services;

import com.listek.bookstore.DTO.ProductDetailsDTO;
import com.listek.bookstore.DTO.ProductListDTO;
import com.listek.bookstore.models.Book;
import com.listek.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<ProductListDTO> getProducts(){
        System.out.println("Get products");
        List<Object[]> books = bookRepository.findBooks();
        List<ProductListDTO> booksToData = new ArrayList<>();
        for (Object[] bookObj:books){
            booksToData.add(new ProductListDTO(bookObj));
        }
        return booksToData;
    }

    public List<ProductListDTO> getProductsByCategory(int idK){
        System.out.println("Get products by category");
        List<Object[]> books = bookRepository.findBooksByCategory(Long.valueOf(idK));
        List<ProductListDTO> booksToData = new ArrayList<>();
        for (Object[] bookObj:books){
            booksToData.add(new ProductListDTO(bookObj));
        }
        return booksToData;
    }

    public ResponseEntity getProduct(int idP){
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

    public ResponseEntity getProductOptimized(int idP) {
        System.out.println("Get product");
        Optional<Object[]> bookObj = bookRepository.findBook(Long.valueOf(idP));
        if (bookObj.isPresent() && bookObj.get().length > 0) {
            ProductDetailsDTO bookDTO = new ProductDetailsDTO(bookObj.get());
            if (bookDTO.getId() != 0) {
                System.out.println("Book found.");
                return new ResponseEntity(bookDTO, HttpStatus.OK);
            } else {
                System.out.println("Book not found.");
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } else {
            System.out.println("Book not found.");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
