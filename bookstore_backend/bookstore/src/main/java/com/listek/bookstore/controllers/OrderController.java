package com.listek.bookstore.controllers;

import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.Order;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ClientRepository clientRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    @GetMapping("orders/{clientID}")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<List<Order>> getOrders(@PathVariable Long clientID){
//        Optional<Client> client = clientRepository.findClientById(clientID);
//        return orderRepository.findByOrderHistoryClient_Id(clientID);
//    }

    @GetMapping("order/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Optional<Order> getOrder(@PathVariable Long id){
        return orderRepository.findById(id);
    }
}
