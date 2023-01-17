package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name="Zamowienia")
@JsonIgnoreProperties("orderHistory")
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

    public Order(Long id, LocalDateTime date, int discount, OrderStatus orderStatus, String orderNumber, Cart cart, Document document, Payment payment, Delivery delivery, Complaint complaint, OrderHistory orderHistory) {
        this.id = id;
        this.date = date;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.cart = cart;
        this.document = document;
        this.payment = payment;
        this.delivery = delivery;
        this.complaint = complaint;
        this.orderHistory = orderHistory;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }

    public double getSum() {
        computeSum();
        return sum;
    }

    public void computeSum(){
        double sum = 0;
        sum += delivery.getCost();
        sum -= discount;
        for (CartItem cartItem: cart.getCartItems()){
            sum += cartItem.getCosts();
        }
        this.sum = sum;
    }

    /**
        Function returns remaining BookCoins (if client passed more than he should)
     **/
    public int grantDiscount(int bookCoins){
        int usedBookCoins;
        computeSum();
        usedBookCoins = Math.min(bookCoins, (int)(0.3 * sum));
        this.discount = usedBookCoins;
        return bookCoins - usedBookCoins;
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
                usedBookCoins);
    }
}
