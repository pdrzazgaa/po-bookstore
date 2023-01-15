package com.listek.bookstore.controllers;

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

    @GetMapping(value = "/{email}/{password}", produces = "application/json")
    public HashMap<String, Long> getUserAccountByEmailAndPassword(@PathVariable("email") String email,
                                                 @PathVariable("password") String password) {
        Optional<UserAccount> tutorialData = repository.findUserAccountByEmailAndPassword(email, password);
        HashMap response = new HashMap();
        response.put("id", -1);

        if (tutorialData.isPresent()) {
            response.put("id", tutorialData.get().getId());
        } else {
            response.put("id", Long.valueOf(-1));
        }
        return response;
    }

}
