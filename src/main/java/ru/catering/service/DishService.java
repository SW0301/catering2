package ru.catering.service;

import ru.catering.model.Dish;
import ru.catering.repository.DishRepository;

public class DishService {

    private  final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Long createDish(Dish dishFromAdmin){
        Dish dish = new Dish();
        dish.setName(dishFromAdmin.getName());
        dish.setCookingTime(dishFromAdmin.getCookingTime());
        dish.setPrice(dishFromAdmin.getPrice());
        dish.setWeight(dishFromAdmin.getWeight());
        dish.setKitchenId(dishFromAdmin.getKitchenId());
        dish.setDeleted(false);
        dishRepository.save(dish);
        return dish.getId();
    }

    public Dish getDish(Long id){
        return dishRepository.getById(id);
    }

    public void deleteDish(Long id){
        Dish dish = dishRepository.getById(id);
        dish.setDeleted(true);
        dishRepository.save(dish);
    }
}
