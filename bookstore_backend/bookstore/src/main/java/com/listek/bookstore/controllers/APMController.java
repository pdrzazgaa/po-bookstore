package com.listek.bookstore.controllers;


import com.listek.bookstore.models.APM;
import com.listek.bookstore.repositories.APMRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APMController {

    APMRepository apmRepository;

    public APMController(APMRepository apmRepository) {
        this.apmRepository = apmRepository;
    }

    @GetMapping
    @RequestMapping("/APMs")
    public List<APM> getAPMs(){
        List<APM> APMs =  apmRepository.findAll();
        return APMs;
    }
}
