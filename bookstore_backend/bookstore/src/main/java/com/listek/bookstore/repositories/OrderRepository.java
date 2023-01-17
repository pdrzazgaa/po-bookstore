package com.listek.bookstore.repositories;

import com.listek.bookstore.DTO.OrdersDTO;
import com.listek.bookstore.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("select o from Order o " +
            "where o.orderHistory.client.id = :clientID order by o.date desc")
    List<Order> findByOrderHistoryClient_Id(Long clientID);

    @Query("select o from Order o " +
            "where o.orderNumber = :orderNumber and o.orderHistory.client.id = :clientID")
    Optional<Order> findByOrderNumber(String orderNumber, Long clientID);
}
