package com.listek.bookstore.services;

import com.listek.bookstore.DTO.DocumentDTO;
import com.listek.bookstore.DTO.OrderDTO;
import com.listek.bookstore.DTO.OrdersDTO;
import com.listek.bookstore.DTO.PaymentDTO;
import com.listek.bookstore.models.*;
import com.listek.bookstore.repositories.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderHistoryRepository orderHistoryRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    AddressRepository addressRepository;

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
        System.out.println(orderDTO);
        Optional<Cart> cart = cartRepository.findById(orderDTO.getCartId());
        return cart
                .map(foundCart -> {
                    Optional<OrderHistory> orderHistory = orderHistoryRepository.findOrderHistoryByClientId(foundCart.getClient().getId());
                    return orderHistory
                            .map(foundOrderHistory -> {
                                // #TODO generating order number;
                                String orderNumber = "123-2023";
                                Order order = new Order(LocalDateTime.now(), orderDTO.getBookcoins(), OrderStatus.OrderPaymentDue, orderNumber, foundCart, foundOrderHistory);
                                Address address = orderDTO.getAddress().fromAddressDTOtoAddress(orderDTO.getForname(), orderDTO.getSurname(), orderDTO.getMail(), orderDTO.getPhoneNumber());
                                addressRepository.save(address);
                                Payment payment = new PaymentDTO(orderDTO.getPayment()).fromPaymentDTOtoPayment(order);
                                paymentRepository.save(payment);
                                Document document = new DocumentDTO(orderDTO.getDocument()).fromDocumentDTOtoDocument(order, orderDTO.getNip(), orderDTO.getCompanyName());
                                documentRepository.save(document);
                                Delivery delivery = orderDTO.getDelivery().fromDeliveryDTOtoDelivery(address, order);
                                deliveryRepository.save(delivery);

                                return new ResponseEntity<>(HttpStatus.OK);
                            })
                            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
