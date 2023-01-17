package com.listek.bookstore.controllers;

import com.listek.bookstore.DTO.OrderDTO;
import com.listek.bookstore.DTO.OrdersDTO;
import com.listek.bookstore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orders/{clientID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getOrders(@PathVariable Long clientID){
        return orderService.getOrders(clientID);
    }

    @GetMapping("order/{orderNumber}/{clientID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getOrder(@PathVariable String orderNumber, @PathVariable  Long clientID){
        return orderService.getOrder(orderNumber, clientID);
    }

    @PostMapping("/createOrder")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }
}
