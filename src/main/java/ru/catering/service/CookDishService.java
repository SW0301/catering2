package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.CookDish;
import ru.catering.repository.CookDishRepository;

@Service
public class CookDishService {
    private final CookDishRepository cookDishRepository;

    public CookDishService(CookDishRepository cookDishRepository) {
        this.cookDishRepository = cookDishRepository;
    }

    public void createCookDish (CookDish cookDishFromAdmin){
        CookDish cookDish = new CookDish();
        cookDish.setCook(cookDishFromAdmin.getCook());
        cookDish.setDish(cookDishFromAdmin.getDish());
    }
}
