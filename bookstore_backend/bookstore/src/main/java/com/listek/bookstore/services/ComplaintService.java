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
        Optional<Client> client = clientRepository.findClientById(complaintDTO.getClientId());
        return client
                .map(foundClient -> {
                    Optional<Order> order = orderRepository.findByOrderNumber(complaintDTO.getOrderNumber(), foundClient.getId());
                    return order
                            .map(foundOrder -> {
                                Complaint complaint = new Complaint(foundOrder);
                                complaintRepository.save(complaint);
                                for (ProductComplaintDTO productComplaintDTO : complaintDTO.getReclamationPosition()) {
                                    Optional<Book> book = bookRepository.findById(productComplaintDTO.getProductID());
                                    if (book.isPresent()) {
                                        ComplaintItem complaintItem = productComplaintDTO.fromProductComplaintDTOtoComplaintItem(book.get(), complaint);
                                        complaintItemRepository.save(complaintItem);
                                        complaint.addComplaintItem(complaintItem);
                                    }
                                }
                                return ResponseEntity.ok(HttpStatus.OK);
                            })
                            .orElseGet(() -> ResponseEntity.ok(HttpStatus.NOT_FOUND));
                })
                .orElseGet(() -> ResponseEntity.ok(HttpStatus.NOT_FOUND));
    }

}
