package com.listek.bookstore.repositories;

import com.listek.bookstore.models.OrderHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {
    Optional<OrderHistory> findOrderHistoryByClientId(Long id);

}
