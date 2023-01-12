package com.listek.bookstore.controllers;

import com.listek.bookstore.models.Order;
import com.listek.bookstore.repositories.OrderRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("orders/{clientID}")
    public List<Order> getOrders(@PathVariable Long clientID){
        return orderRepository.findByOrderHistoryClient_Id(clientID);
    }

    @RequestMapping("order/{clientID}")
    public Optional<Order> getOrder(@PathVariable Long id){
        return orderRepository.findById(id);
    }
}
