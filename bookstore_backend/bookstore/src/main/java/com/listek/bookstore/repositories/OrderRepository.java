package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
