package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    //@Query("select id, nazwa, kategoria_nadrzedna from kategorie")

}
