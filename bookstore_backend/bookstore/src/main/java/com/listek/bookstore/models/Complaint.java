package com.listek.bookstore.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name="Reklamacje")
@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="DataReklamacji")
    private LocalDateTime complaintDate;
    @Column(name="NumerKonta")
    private String accountNumber;
    @Column(name="StatusReklamacji")
    private ComplaintStatus complaintStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ZamowienieID")
    private Order order;
    @OneToMany(mappedBy="complaint", cascade = CascadeType.ALL)
    private List<ComplaintItem> complaintItems;

    public Complaint(Order order) {
        this.complaintDate = LocalDateTime.now();
        generateAccountNumber();
        this.complaintStatus = ComplaintStatus.ComplaintPending;
        this.order = order;
        complaintItems = new ArrayList<>();
    }

    private void generateAccountNumber(){
        accountNumber =(int) (Math.random() * 100) +  " ";
        for (int i=0; i<6; i++) accountNumber += (int) (Math.random() * 10000) + " ";
    }

   public void addComplaintItem(ComplaintItem complaintItem){
        this.complaintItems.add(complaintItem);
   }
}
