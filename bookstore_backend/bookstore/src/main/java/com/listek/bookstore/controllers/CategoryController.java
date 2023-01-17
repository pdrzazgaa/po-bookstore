package com.listek.bookstore.controllers;

import com.listek.bookstore.models.Category;
import com.listek.bookstore.repositories.CategoryRepository;
import com.listek.bookstore.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController {

   CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/categories")
    public ResponseEntity getCategories(){
        return new ResponseEntity(categoryService.getCategories(), HttpStatus.OK);
    }
}
