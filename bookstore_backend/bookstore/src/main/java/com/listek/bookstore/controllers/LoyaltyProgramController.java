package com.listek.bookstore.controllers;

import com.listek.bookstore.DTO.IdDTO;
import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.LoyaltyProgram;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.LoyaltyProgramRepository;
import com.listek.bookstore.DTO.LoyaltyProgramDTO;
import com.listek.bookstore.services.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoyaltyProgramController {

    @Autowired
    LoyaltyProgramService loyaltyProgramService;

    public LoyaltyProgramController(LoyaltyProgramService loyaltyProgramService) {
        this.loyaltyProgramService = loyaltyProgramService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/joinLoyaltyProgram")
    public ResponseEntity<HttpStatus> joinLoyaltyProgram(@RequestBody IdDTO clientID) {
        return loyaltyProgramService.joinLoyaltyProgram(clientID);
    }

    @GetMapping("/checkLoyaltyProgram/{clientID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity checkLoyaltyProgram(@PathVariable("clientID") int clientID) {
        return loyaltyProgramService.checkLoyaltyProgram(clientID);
    }
}
