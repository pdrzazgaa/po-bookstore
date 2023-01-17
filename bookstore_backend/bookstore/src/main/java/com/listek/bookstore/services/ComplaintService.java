package com.listek.bookstore.services;

import com.listek.bookstore.DTO.ComplaintDTO;
import com.listek.bookstore.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {
    @Autowired
    ComplaintRepository complaintRepository;

    public ResponseEntity placeComplaint(ComplaintDTO complaintDTO){
        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

}
