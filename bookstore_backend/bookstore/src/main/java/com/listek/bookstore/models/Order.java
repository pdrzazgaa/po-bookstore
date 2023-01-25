package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@Table(name="Zamowienia")
@JsonIgnoreProperties(value = {"orderHistory", "document", "payment", "delivery", "orderHistory", "usedBookCoins"})
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="KoszykID")
    private Cart cart;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Document document;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Delivery delivery;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Complaint complaint;
    @ManyToOne
    @JoinColumn(name="HistoriaZamowienID")
    private OrderHistory orderHistory;
    @Transient
    @JsonInclude
    private double sum;
    @Transient
    private int usedBookCoins;
    @Transient
    private boolean isPossibleComplaint = isPossibleComplaint();

    public Order(int bookCoins, Cart cart, OrderHistory orderHistory) {
        this.date = LocalDateTime.now();
        this.orderStatus = OrderStatus.OrderPaymentDue;
        this.cart = cart;
        this.orderHistory = orderHistory;
        grantDiscount(bookCoins);
        generateOrderNumber();
    }

    public double computeSum(){
        double sum = computeSumWithoutDeliveryAndDiscount();
        sum += delivery.getCost();
        sum -= discount;
        this.sum = sum;
        return sum;
    }

    public double computeSumWithoutDeliveryAndDiscount(){
        double sum = 0;
        for (CartItem cartItem: cart.getCartItems()){
            sum += cartItem.getCosts();
        }
        return sum;
    }

    private void generateOrderNumber(){
        this.orderNumber = (int)(Math.random() * 10000) +"-2023";
    }

    public boolean isPossibleComplaint(){
        if (complaint != null || date == null) return false;
        long days = ChronoUnit.DAYS.between(date, LocalDateTime.now());
        return days < 30 && orderStatus == OrderStatus.OrderDelivered;
    }

    /**
        Function computes a discount for the order.
        Discount equals passed number of bookcoins or 30% of the orders cost.
        (the lower value)
     **/

    public int grantDiscount(int bookCoins){
        this.discount = Math.min(bookCoins, (int)(0.3 * computeSumWithoutDeliveryAndDiscount()));
        return discount;
    }

    /**
     * Not used. Not included in use case.
     */
    public void payForOrder(){
        this.orderStatus = OrderStatus.OrderPaid;
            addBookCoinsToClient();
    }
    /**
     * Not used. Not included in use case.
     */
    public void addBookCoinsToClient(){
        computeSum();
        this.orderHistory.getClient().getLoyaltyProgram().addBookCoins(
                (int) (this.sum / 20)
        );
    }
    /**
     * Not used. Not included in use case.
     */
    public boolean takeBookCoinsFromClient(){
        computeSum();
        return this.orderHistory.getClient().getLoyaltyProgram().removeBookCoins(
                discount);
    }
}
