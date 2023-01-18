package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

/**
 * An abstract class for payments
 */

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
@JsonIgnoreProperties("order")
@Entity
public abstract class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "DataPlatnosci")
    private LocalDateTime paymentDate;
    @JoinColumn(name = "ZamowienieID")
    @OneToOne(cascade = CascadeType.ALL)
    private Order order;

    public Payment(Order order) {
        this.paymentDate = LocalDateTime.now();
        this.order = order;
    }

}
