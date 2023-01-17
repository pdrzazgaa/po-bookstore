package com.listek.bookstore.repositories;

import com.listek.bookstore.models.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
