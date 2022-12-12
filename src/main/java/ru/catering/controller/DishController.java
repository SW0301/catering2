package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Dish;
import ru.catering.service.DishService;

import java.util.List;

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

    @GetMapping(value = "/dish/{id}")
    public Dish getDishById(@PathVariable Long id) {
        return dishService.getDish(id);
    }

    @DeleteMapping(value = "/dish/{dishId}")
    public void deleteFish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
    }

    @GetMapping(value="/dish/all")
    public List<Dish> findAll(){
        return dishService.findAll();
    }

    @GetMapping(value="/dish/correl")
    public double getCorrelation(@RequestParam String param){
        return dishService.correlWithPrice(param);
    }
    @GetMapping(value = "/dish/distanceBetweenValues")
    public double[][] distanceBetweenValues(@RequestParam String param){
        return dishService.distanceBetweenValues(param);
    }
}