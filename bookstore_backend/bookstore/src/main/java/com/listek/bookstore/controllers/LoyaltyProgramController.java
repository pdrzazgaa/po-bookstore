package com.listek.bookstore.controllers;

import com.listek.bookstore.fromToModels.IdForm;
import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.LoyaltyProgram;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.LoyaltyProgramRepository;
import com.listek.bookstore.fromToModels.LoyaltyProgramToData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoyaltyProgramController {

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;
    @Autowired
    ClientRepository clientRepository;

    public LoyaltyProgramController(LoyaltyProgramRepository loyaltyProgramRepository, ClientRepository clientRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
        this.clientRepository = clientRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/joinLoyaltyProgram")
    public ResponseEntity<HttpStatus> joinLoyaltyProgram(@RequestBody IdForm clientID) {
        Optional<Client> client = clientRepository.findClientById(Long.valueOf(clientID.getId()));
        return client
                .map(foundClient -> {
                    System.out.println("Client found");
                    Optional<LoyaltyProgram> loyaltyProgram = loyaltyProgramRepository.findByClient_Id(Long.valueOf(clientID.getId()));
                    return loyaltyProgram
                            .map(foundLoyaltyProgram -> {
                                    System.out.println("Loyalty program found. Cannot join.");
                                    return ResponseEntity.ok(HttpStatus.FOUND);
                            })
                            .orElseGet(() -> {
                                    System.out.println("Loyalty program not found. Joining client.");
                                    LoyaltyProgram newLoyaltyProgram = new LoyaltyProgram();
                                    newLoyaltyProgram.setClient(foundClient);
                                    loyaltyProgramRepository.save(newLoyaltyProgram);
                                    return ResponseEntity.ok(HttpStatus.OK);
                            });
                })
                .orElseGet(() -> {
                    System.out.println("Client not found");
                    return ResponseEntity.ok(HttpStatus.NOT_FOUND);
                });
    }

    @GetMapping("/checkLoyaltyProgram/{clientID}")
    @CrossOrigin(origins = "http://localhost:4200")
    public LoyaltyProgramToData checkLoyaltyProgram(@PathVariable("clientID") int clientID) {
        LoyaltyProgramToData loyaltyProgramToDataResponse = new LoyaltyProgramToData();
        return loyaltyProgramRepository.findByClient_Id(Long.valueOf(clientID))
                .map(loyaltyProgram -> {
                    System.out.println("Client is a participant");
                    loyaltyProgramToDataResponse.setParticipant(true);
                    loyaltyProgramToDataResponse.setBookcoins(loyaltyProgram.getBookcoins());
                    return loyaltyProgramToDataResponse;
                })
                .orElseGet(() -> {
                    System.out.println("Client is not a participant");
                    loyaltyProgramToDataResponse.setParticipant(false);
                    loyaltyProgramToDataResponse.setBookcoins(0);
                    return loyaltyProgramToDataResponse;
                });
    }
}
