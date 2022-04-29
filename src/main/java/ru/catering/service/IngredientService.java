package ru.catering.service;

import ru.catering.model.Ingredient;
import ru.catering.repository.IngredientRepository;

public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Long createIngredient(Ingredient ingredientFromClient){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientFromClient.getName());
        ingredient.setDeleted(false);
        ingredient.setCategory(ingredientFromClient.getCategory());
        ingredientRepository.save(ingredient);
        return ingredient.getId();
    }

    public Ingredient getIngredient(Long id){
        return ingredientRepository.getById(id);
    }

    public void deleteIngredient(Long id){
        Ingredient ingredient = ingredientRepository.getById(id);
        ingredient.setDeleted(true);
        ingredientRepository.save(ingredient);
    }
}
