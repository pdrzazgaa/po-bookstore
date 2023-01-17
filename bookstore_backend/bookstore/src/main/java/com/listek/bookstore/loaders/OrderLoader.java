package com.listek.bookstore.loaders;

import com.listek.bookstore.models.*;
import com.listek.bookstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@Order(5)
public class OrderLoader implements CommandLineRunner {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DocumentRepository documentRepository;
    @Autowired
    OrderHistoryRepository orderHistoryRepository;


    @Override
    public void run(String... args) throws Exception {
        loadOrdersData();
    }


    private void loadOrdersData(){
        if (orderRepository.count() == 0) {
            Optional<OrderHistory> orderHistory = orderHistoryRepository.findOrderHistoryByClientId(Long.valueOf(1));
            Optional<Cart> cart = cartRepository.findFirst();
            if (orderHistory.isPresent() && cart.isPresent()) {
                com.listek.bookstore.models.Order order = new com.listek.bookstore.models.Order(
                        LocalDateTime.now(), 10, OrderStatus.OrderPaymentDue, "1-2023",
                        cart.get(), orderHistory.get());
                orderRepository.save(order);

                Address address = new Address("Maria", "Markowiak", "m.a.markowiak@gmail.com", "123 456 789",
                        "Traugutta", "132/47", "12-345", "Wrocław", "Polska");
                addressRepository.save(address);
                Delivery delivery = new APMDelivery(9.99, address, "WRO12B", order);
                deliveryRepository.save(delivery);
                Payment payment = new TransferPayment(LocalDateTime.now(), "72 1234 5678 0000 9820", order);
                paymentRepository.save(payment);
                Document document = new Receipt(LocalDateTime.now(), order);
                documentRepository.save(document);
            }

        }
        System.out.println(orderRepository.count());

    }
}
