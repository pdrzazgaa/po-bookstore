package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = TABLE_PER_CLASS)
@JsonIgnoreProperties("order")
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

    public Payment(LocalDateTime paymentDate, Order order) {
        this.paymentDate = paymentDate;
        this.order = order;
    }

}
