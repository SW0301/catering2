package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Dish;
import ru.catering.service.DishService;

@RestController
public class DishController {

    private DishService dishService;

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping(value = "/dish")
    public Long createDish(@RequestBody Dish dishFromAdmin) {
        return dishService.createDish(dishFromAdmin);
    }

    @GetMapping(value = "/dish")
    public Dish getDishById(@RequestParam Long id) {
        return dishService.getDish(id);
    }

    @DeleteMapping(value = "/dish/{dishId}")
    public void deleteFish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
    }
}