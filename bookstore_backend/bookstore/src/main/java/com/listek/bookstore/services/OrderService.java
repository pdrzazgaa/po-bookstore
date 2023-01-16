package com.listek.bookstore.services;

import com.listek.bookstore.DTO.OrderDTO;
import com.listek.bookstore.DTO.OrdersDTO;
import com.listek.bookstore.models.*;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    ClientRepository clientRepository;
    OrderRepository orderRepository;

    public OrderService(ClientRepository clientRepository, OrderRepository orderRepository) {
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
    }

    public ResponseEntity getOrders(Long clientID){
        Optional<Client> client = clientRepository.findClientById(clientID);
        return client
                .map(foundClient -> {
                    List<Order> orders = orderRepository.findByOrderHistoryClient_Id(clientID);
                    List<OrdersDTO> ordersDTOs = new ArrayList<>();
                    for (Order order : orders)
                        ordersDTOs.add(OrdersDTO.fromOrderToOrdersDTO(order));
                    System.out.println("Orders found.");
                    return new ResponseEntity<>(ordersDTOs, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    System.out.println("Client not found.");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    public ResponseEntity getOrder(String orderNumber, Long clientID){
        Optional<Client> client = clientRepository.findClientById(clientID);
        return client
                .map(foundClient -> {
                    Optional<Order> order = orderRepository.findByOrderNumber(orderNumber,
                            clientID);
                    return order
                            .map(foundOrder -> {
                                foundOrder.computeSum();
                                System.out.println("Order found.");
                                return new ResponseEntity<>(foundOrder, HttpStatus.OK);
                            })
                            .orElseGet(()->{
                                System.out.println("Order not found.");
                                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                            });
                })
                .orElseGet(() -> {
                    System.out.println("Client not found.");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    public ResponseEntity createOrder(OrderDTO orderDTO){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
