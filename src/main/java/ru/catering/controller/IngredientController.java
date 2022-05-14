package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Ingredient;
import ru.catering.service.IngredientService;


@RestController
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public void setIngredientService(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @PostMapping(value = "/ingredient/create")
    public void createIngredient(@RequestBody Ingredient ingredientFromAdmin){
        ingredientService.createIngredient(ingredientFromAdmin);
    }

    @GetMapping(value = "/ingredient/get")
    public Ingredient getIngredientById(@RequestParam Long id){return ingredientService.getIngredient(id);}
}
