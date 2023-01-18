package com.listek.bookstore.services;

import com.listek.bookstore.DTO.ComplaintDTO;
import com.listek.bookstore.DTO.ProductComplaintDTO;
import com.listek.bookstore.models.*;
import com.listek.bookstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ComplaintItemRepository complaintItemRepository;
    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity placeComplaint(ComplaintDTO complaintDTO) {
        Optional<Client> client = clientRepository.findClientById(complaintDTO.getUserId());
        return client
                .map(foundClient -> {
                    Optional<Order> order = orderRepository.findByOrderNumber(complaintDTO.getOrderNumber(), foundClient.getId());
                    return order
                            .map(foundOrder -> {
                                if (!foundOrder.isComplained()) {
                                    Complaint complaint = new Complaint(foundOrder);
                                    complaintRepository.save(complaint);
                                    for (ProductComplaintDTO productComplaintDTO : complaintDTO.getReclamationPositions()) {
                                        Optional<Book> book = bookRepository.findById(productComplaintDTO.getProductId());
                                        if (book.isPresent()) {
                                            ComplaintItem complaintItem = productComplaintDTO.fromProductComplaintDTOtoComplaintItem(book.get(), complaint);
                                            complaintItemRepository.save(complaintItem);
                                            complaint.addComplaintItem(complaintItem);
                                        }
                                    }
                                    System.out.println("Complaint created.");
                                    return ResponseEntity.ok(HttpStatus.OK);
                                } else {
                                    return ResponseEntity.ok(HttpStatus.FOUND);
                                }
                            })
                            .orElseGet(() -> {
                                System.out.println("Complaint not created. Order not found.");
                                return ResponseEntity.ok(HttpStatus.NOT_FOUND);}
                            );
                })
                .orElseGet(() -> {
                    System.out.println("Complaint not created. Client not found.");
                    return ResponseEntity.ok(HttpStatus.NOT_FOUND);}
                );
    }

}
