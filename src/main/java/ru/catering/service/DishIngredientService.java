package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.DishIngredient;
import ru.catering.repository.DishIngredientRepository;

@Service
public class DishIngredientService {

    private final DishIngredientRepository dishIngredientRepository;

    public DishIngredientService(DishIngredientRepository dishIngredientRepository) {
        this.dishIngredientRepository = dishIngredientRepository;
    }

    public void setDishIngredient(DishIngredient dishIngredientFromAdmin){
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setDish(dishIngredientFromAdmin.getDish());
        dishIngredient.setIngredient(dishIngredientFromAdmin.getIngredient());
    }
}
