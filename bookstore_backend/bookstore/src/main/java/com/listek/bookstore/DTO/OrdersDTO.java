package com.listek.bookstore.DTO;

import com.listek.bookstore.models.Order;
import com.listek.bookstore.models.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {
    private Long id;
    private String orderNumber;
    private OrderStatus orderStatus;
    private LocalDateTime date;
    private double sum;

    public static OrdersDTO fromOrderToOrdersDTO(Order order){
        if (order == null) return null;
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.id = order.getId();
        ordersDTO.orderNumber = order.getOrderNumber();
        ordersDTO.orderStatus = order.getOrderStatus();
        ordersDTO.date = order.getDate();
        ordersDTO.sum = order.getSum();
        return ordersDTO;
    }
}
