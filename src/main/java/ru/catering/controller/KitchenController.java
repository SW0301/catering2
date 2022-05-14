package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Kitchen;
import ru.catering.service.KitchenService;

@RestController
public class KitchenController {
    private KitchenService kitchenService;

    @Autowired
    public void setKitchentService(KitchenService kitchenService){
        this.kitchenService = kitchenService;
    }

    @PostMapping(value = "/kitchen/create")
    public void createKitchen(@RequestBody Kitchen kitchenFromAdmin){
        kitchenService.createKitchen(kitchenFromAdmin);
    }

    @GetMapping(value = "/kitchen/get")
    public Kitchen getKitchenById(@RequestParam Long id){return kitchenService.getKitchen(id);}
}
