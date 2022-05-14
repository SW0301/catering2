package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Cook;
import ru.catering.service.CookService;

@RestController
public class CookController {

    private CookService cookService;

    @Autowired
    public void setCookService(CookService cookService){
        this.cookService = cookService;
    }

    @PostMapping(value = "/cook/create")
    public void createCook(@RequestBody Cook cookFromAdmin){
        cookService.createCook(cookFromAdmin);
    }

    @GetMapping(value = "/cook/get")
    public Cook getCookById(@RequestParam Long id){return cookService.getCook(id);}
}
