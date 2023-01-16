package com.listek.bookstore.controllers;

import com.listek.bookstore.models.Category;
import com.listek.bookstore.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController {

    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    @RequestMapping("/categories")
    public Category getCategories(){
        List<Category> categories =  categoryRepository.findAll();
        System.out.println("Categories found.");
        return categories.get(0);
    }
}
