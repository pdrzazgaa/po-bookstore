package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Modifying
    @Query("update Product set numberOfItemsInStock = :itemsInStock where id = :id")
    void updateItemsInStock(@Param("itemsInStock") int itemsInStock, @Param("id") long id);
}
