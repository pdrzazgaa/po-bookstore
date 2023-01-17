package com.listek.bookstore.services;

import com.listek.bookstore.DTO.IdDTO;
import com.listek.bookstore.DTO.LoyaltyProgramDTO;
import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.LoyaltyProgram;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.LoyaltyProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class LoyaltyProgramService {

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;
    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<HttpStatus> joinLoyaltyProgram(IdDTO clientID) {
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

    public ResponseEntity checkLoyaltyProgram(int clientID) {
        LoyaltyProgramDTO loyaltyProgramDTOResponse = new LoyaltyProgramDTO();
        return clientRepository.findClientById(Long.valueOf(clientID))
                .map(foundClient -> loyaltyProgramRepository.findByClient_Id(Long.valueOf(clientID))
                        .map(loyaltyProgram -> {
                            System.out.println("Client is a participant");
                            loyaltyProgramDTOResponse.setParticipant(true);
                            loyaltyProgramDTOResponse.setBookcoins(loyaltyProgram.getBookcoins());
                            return new ResponseEntity(loyaltyProgramDTOResponse, HttpStatus.OK);
                        })
                        .orElseGet(() -> {
                            System.out.println("Client is not a participant");
                            loyaltyProgramDTOResponse.setParticipant(false);
                            loyaltyProgramDTOResponse.setBookcoins(0);
                            return new ResponseEntity(loyaltyProgramDTOResponse, HttpStatus.OK);
                        }))
                .orElseGet(() -> ResponseEntity.ok(HttpStatus.NOT_FOUND));
    }
}
