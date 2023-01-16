package com.listek.bookstore.controllers;

import com.listek.bookstore.DTO.UserDTO;
import com.listek.bookstore.models.UserAccount;
import com.listek.bookstore.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("verify")
public class UserAccountController {
    @Autowired
    UserAccountRepository repository;

    public UserAccountController(UserAccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public HashMap<String, Long> getUserAccountByEmailAndPassword(@RequestBody UserDTO userDTO) {
        Optional<UserAccount> tutorialData =
                repository.findUserAccountByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        HashMap response = new HashMap();
        response.put("id", -1);

        if (tutorialData.isPresent()) {
            System.out.println("User found.");
            response.put("id", tutorialData.get().getId());
        } else {
            System.out.println("User not found.");
            response.put("id", Long.valueOf(-1));
        }
        return response;
    }

}
