package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.catering.model.DishIngredient;
import ru.catering.service.DishIngredientService;

import java.util.List;

@RestController
public class DishIngredientController {
    private DishIngredientService dishIngredientService;

    @Autowired
    public void setDishIngredientService(DishIngredientService dishIngredientService) {
        this.dishIngredientService = dishIngredientService;
    }

    @GetMapping(value = "/dishIngredient/all")
    public List<DishIngredient> findAll(){
        return dishIngredientService.findAll();
    }
}
