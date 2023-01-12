package com.listek.bookstore.repositories;

import com.listek.bookstore.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByOrderHistoryClient_Id(Long clientID);

    Optional<Order> findById(Long id);
}
