package com.listek.bookstore.controllers;

import com.listek.bookstore.models.Category;
import com.listek.bookstore.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class CategoryController {

    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    @RequestMapping("/categories")
    public String getCategories(){
        ArrayList<Category> categories = (ArrayList<Category>) categoryRepository.findAll();
        return "kategorie";
    }
}
