package com.listek.bookstore.controllers;

import com.listek.bookstore.fromToModels.UserFromData;
import com.listek.bookstore.models.UserAccount;
import com.listek.bookstore.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public HashMap<String, Long> getUserAccountByEmailAndPassword(@RequestBody UserFromData userFromData) {
        Optional<UserAccount> tutorialData =
                repository.findUserAccountByEmailAndPassword(userFromData.getEmail(), userFromData.getPassword());
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
