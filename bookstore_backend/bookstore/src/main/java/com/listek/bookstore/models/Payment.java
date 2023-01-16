package com.listek.bookstore.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Inheritance(strategy = TABLE_PER_CLASS)
@Table(name="Platnosci")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DataPlatnosci")
    private LocalDateTime paymentDate;
    @JoinColumn(name = "ZamowienieID")
    @OneToOne
    private Order order;

    public Payment(Long id, LocalDateTime paymentDate) {
        this.id = id;
        this.paymentDate = paymentDate;
    }

    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}