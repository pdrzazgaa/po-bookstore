package com.listek.bookstore.services;

import com.listek.bookstore.models.Category;
import com.listek.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategories(){
        List<Category> categories =  categoryRepository.findAll();
        System.out.println("Categories found.");
        return categories.get(0);
    }
}
