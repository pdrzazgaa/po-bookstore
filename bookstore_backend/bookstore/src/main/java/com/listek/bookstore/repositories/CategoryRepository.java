package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select id, name, parentCategory from Category ")
    List<Category>  getCategories();
    List<Category> findCategoriesByParentCategory(Category category);
    List<Category> findAll();



}
