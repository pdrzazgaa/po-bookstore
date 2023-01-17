package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name="Zamowienia")
@JsonIgnoreProperties(value = {"orderHistory", "document", "payment", "delivery", "orderHistory"})
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="DataZlozeniaZamowienia")
    private LocalDateTime date;
    @Column(name="Rabat")
    private int discount;
    @Column(name="StatusZamowienia")
    private OrderStatus orderStatus;
    @Column(name="NumerZamowienia")
    private String orderNumber;
    @OneToOne
    @JoinColumn(name="KoszykID")
    private Cart cart;
    @OneToOne(mappedBy = "order")
    private Document document;
    @OneToOne(mappedBy = "order")
    private Payment payment;
    @OneToOne(mappedBy = "order")
    private Delivery delivery;
    @OneToOne(mappedBy = "order")
    private Complaint complaint;
    @ManyToOne
    @JoinColumn(name="HistoriaZamowienID")
    private OrderHistory orderHistory;
    @Transient
    @JsonInclude
    private double sum;
    @Transient
    private int usedBookCoins;


    public Order(LocalDateTime date, int bookCoins, OrderStatus orderStatus, String orderNumber, Cart cart,
                OrderHistory orderHistory) {
        this.date = date;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.cart = cart;
        this.orderHistory = orderHistory;
        grantDiscount(bookCoins);
    }

    public Order(LocalDateTime date, int bookCoins, OrderStatus orderStatus, String orderNumber, Cart cart,
                 Document document, Payment payment, Delivery delivery, OrderHistory orderHistory) {
        this.date = date;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.cart = cart;
        this.document = document;
        this.payment = payment;
        this.delivery = delivery;
        this.orderHistory = orderHistory;
        grantDiscount(bookCoins);
    }

    public double getSum() {
        computeSum();
        return sum;
    }

    public void computeSum(){
        double sum = computeSumWithoutDeliveryAndDiscount();
        sum += delivery.getCost();
        sum -= discount;
        this.sum = sum;
    }

    public void computeSumWithoutDiscount(){
        double sum = 0;
        sum += delivery.getCost();
        for (CartItem cartItem: cart.getCartItems()){
            sum += cartItem.getCosts();
        }
        this.sum = sum;
    }

    public double computeSumWithoutDeliveryAndDiscount(){
        double sum = 0;
        for (CartItem cartItem: cart.getCartItems()){
            sum += cartItem.getCosts();
        }
        return sum;
    }

    /**
        Function returns remaining BookCoins (if client passed more than he should)
     **/
    public int grantDiscount(int bookCoins){
        this.discount = Math.min(bookCoins, (int)(0.3 * computeSumWithoutDeliveryAndDiscount()));
        return bookCoins - this.discount;
    }

    public void placeOrder(){
        this.orderStatus = OrderStatus.OrderPaymentDue;
    }

    public void payForOrder(){
        this.orderStatus = OrderStatus.OrderPaid;
            addBookCoinsToClient();
    }

    public void addBookCoinsToClient(){
        computeSum();
        this.orderHistory.getClient().getLoyaltyProgram().addBookCoins(
                (int) (this.sum / 20)
        );
    }

    public boolean takeBookCoinsFromClient(){
        computeSum();
        return this.orderHistory.getClient().getLoyaltyProgram().removeBookCoins(
                discount);
    }
}
