package com.listek.bookstore.controllers;

import com.listek.bookstore.models.UserAccount;
import com.listek.bookstore.repositories.UserAccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserAccountController {

    UserAccountRepository repository;
    @GetMapping("/firstUserAccount/")
    public void getUserData(UserAccountRepository repository){
        System.out.print(repository.findById(1));
    }
}
