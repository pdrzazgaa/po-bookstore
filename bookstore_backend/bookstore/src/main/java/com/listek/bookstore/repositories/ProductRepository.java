package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
