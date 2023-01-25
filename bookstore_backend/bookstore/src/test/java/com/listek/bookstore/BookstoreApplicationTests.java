package com.listek.bookstore;

import com.listek.bookstore.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


@SpringBootTest
class BookstoreApplicationTests {

    @Test
    void testIfComplaintIsPossible(){
        Order order = new Order(10, new Cart(), new OrderHistory());
        // Test no 1. - no existing complaint, date less than 30 days ago, order status: delivered
        order.setOrderStatus(OrderStatus.OrderDelivered);
        order.setComplaint(null);
        order.setDate(LocalDateTime.now());
        Assert.isTrue(order.isPossibleComplaint(), "Possible Complaint - Test no 1.");
        // Test no 2. - no existing complaint, date more than 30 days ago, order status: delivered
        order.setOrderStatus(OrderStatus.OrderDelivered);
        order.setComplaint(null);
        order.setDate(LocalDateTime.of(2022, 12, 1,0,0));
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 2.");
        // Test no 3. - complaint exists, date less than 30 days ago, order status: delivered
        order.setOrderStatus(OrderStatus.OrderDelivered);
        order.setComplaint(new Complaint());
        order.setDate(LocalDateTime.now());
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 3.");
        // Test no 4. - no existing complaint, date less than 30 days ago, order status: not delivered
        order.setOrderStatus(OrderStatus.OrderPaymentDue);
        order.setComplaint(null);
        order.setDate(LocalDateTime.now());
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 4.");
        // Test no 5. - complaint exists, date more than 30 days ago, order status: delivered
        order.setOrderStatus(OrderStatus.OrderDelivered);
        order.setComplaint(new Complaint());
        order.setDate(LocalDateTime.of(2022, 12, 1,0,0));
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 5.");
        // Test no 6. - complaint exists, date less than 30 days ago, order status: not delivered
        order.setOrderStatus(OrderStatus.OrderReadyForSend);
        order.setComplaint(null);
        order.setDate(LocalDateTime.now());
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 6.");
        // Test no 7. - no existing complaint, date more than 30 days ago, order status: not delivered
        order.setOrderStatus(OrderStatus.OrderInTransit);
        order.setComplaint(null);
        order.setDate(LocalDateTime.of(2022, 12, 1,0,0));
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 7.");
        // Test no 8. - complaint exists, date more than 30 days ago, order status: not delivered
        order.setOrderStatus(OrderStatus.OrderInComplaint);
        order.setComplaint(new Complaint());
        order.setDate(LocalDateTime.of(2022, 12, 1,0,0));
        Assert.isTrue(!order.isPossibleComplaint(), "Possible Complaint - Test no 8.");

    }

    @Test
    void testGrandDiscount(){
        Cart cart = new Cart();
        Product product1 = new Product();
        product1.setPrice(79.99);
        CartItem cartItem1 = new CartItem(product1, cart);
        Product product2 = new Product();
        product2.setPrice(49.99);
        CartItem cartItem2 = new CartItem(product2, cart);
        Product product3 = new Product();
        product3.setPrice(29.99);
        CartItem cartItem3 = new CartItem(product3, cart);
        cart.setCartItems(new ArrayList<>(Arrays.asList(cartItem1, cartItem2, cartItem3)));
        Order order = new Order(50, cart, new OrderHistory());

        // GrandDiscount Test no 1 -
        Assert.isTrue((order.grantDiscount(47) == 47), "GrandDiscount Test no 1");
        // GrandDiscount Test no 2 -
        Assert.isTrue((order.grantDiscount(50) == 47), "GrandDiscount Test no 2");
        // GrandDiscount Test no 3 -
        Assert.isTrue((order.grantDiscount(48) == 47), "GrandDiscount Test no 3");
        // GrandDiscount Test no 4 -
        Assert.isTrue((order.grantDiscount(30) == 30), "GrandDiscount Test no 4");
        // GrandDiscount Test no 5 -
        Assert.isTrue((order.grantDiscount(0) == 0), "GrandDiscount Test no 5");
    }
}
