package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Dish;
import ru.catering.service.DishService;

@RestController
public class DishController {

    private DishService dishService;

    @Autowired
    public void setDishService(DishService dishService){
        this.dishService = dishService;}

    @PostMapping(value = "/dish/create")
    public void createDish(@RequestBody Dish dishFromAdmin){
        dishService.createDish(dishFromAdmin);
    }

    @GetMapping(value = "/dish/get")
    public Dish getDishById(@RequestParam Long id){return dishService.getDish(id);}


}
