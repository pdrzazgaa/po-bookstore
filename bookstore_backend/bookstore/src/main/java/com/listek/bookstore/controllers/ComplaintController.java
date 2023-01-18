package com.listek.bookstore.controllers;

import com.listek.bookstore.DTO.ComplaintDTO;
import com.listek.bookstore.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @PostMapping("/createComplaint")
    //@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity createOrder(@RequestBody ComplaintDTO complaintDTO){
        return complaintService.placeComplaint(complaintDTO);
    }

}
