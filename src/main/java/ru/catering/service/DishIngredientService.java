package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.DishIngredient;
import ru.catering.repository.DishIngredientRepository;


import java.util.List;
@Service
public class DishIngredientService {
    private final DishIngredientRepository dishIngredientRepository;

    public DishIngredientService(DishIngredientRepository dishIngredientRepository) {
        this.dishIngredientRepository = dishIngredientRepository;
    }

    public List<DishIngredient> findAll(){
        List<DishIngredient> all = dishIngredientRepository.findAll();
        return all;
    }
}
