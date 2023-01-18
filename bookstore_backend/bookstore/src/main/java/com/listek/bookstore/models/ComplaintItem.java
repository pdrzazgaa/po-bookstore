package com.listek.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@Table(name="PozycjeReklamacji")
@JsonIgnoreProperties("complaint")
@Entity
public class ComplaintItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PowodReklamacji")
    private String complaintReason;
    @Column(name = "ilosc")
    private int quantity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="ProduktID", nullable = false)
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ReklamacjaID")
    private Complaint complaint;

    public ComplaintItem(Long id, String complaintReason, int quantity) {
        this.id = id;
        this.complaintReason = complaintReason;
        this.quantity = quantity;
    }


}
