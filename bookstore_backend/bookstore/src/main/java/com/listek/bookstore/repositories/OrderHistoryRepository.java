package com.listek.bookstore.repositories;

import com.listek.bookstore.models.OrderHistory;
import org.springframework.data.repository.CrudRepository;

public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {
}
