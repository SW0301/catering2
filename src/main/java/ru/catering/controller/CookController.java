package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.dto.CreateCookDTO;
import ru.catering.model.Cook;
import ru.catering.service.CookService;

@RestController
public class CookController {

    private CookService cookService;

    @Autowired
    public void setCookService(CookService cookService) {
        this.cookService = cookService;
    }

    @PostMapping(value = "/cook")
    public Long createCook(@RequestBody CreateCookDTO cookFromAdmin) {
        return cookService.createCook(cookFromAdmin.getCook(), cookFromAdmin.getUserId());
    }

    @GetMapping(value = "/cook")
    public Cook getCookById(@RequestParam Long id) {
        return cookService.getCook(id);
    }
}