package com.listek.bookstore.controllers;

import com.listek.bookstore.models.LoyaltyProgram;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.LoyaltyProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoyaltyProgramController {

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;
    ClientRepository clientRepository;

    public LoyaltyProgramController(LoyaltyProgramRepository loyaltyProgramRepository, ClientRepository clientRepository) {
        this.loyaltyProgramRepository = loyaltyProgramRepository;
        this.clientRepository = clientRepository;
    }

//    @PutMapping("/joinLoyaltyProgram/{id}}")
//    public LoyaltyProgram joinLoyaltyProgram(@RequestBody LoyaltyProgram newLoyaltyProgram, @PathVariable("id") Long id) {
//        return loyaltyProgramRepository.findById(id)
//                .map(loyaltyProgram -> {
//                    loyaltyProgram.setClient(newLoyaltyProgram.getClient());
//                    return loyaltyProgramRepository.save(loyaltyProgram);
//                })
//                .orElseGet(() -> {
//                    newLoyaltyProgram.setClient();
//                    return loyaltyProgramRepository.save(newLoyaltyProgram);
//                });
//    }

}
