package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.Dish;
import ru.catering.repository.DishRepository;

import java.util.*;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Long createDish(Dish dishFromAdmin) {
        Dish dish = new Dish();
        dish.setName(dishFromAdmin.getName());
        dish.setCookingTime(dishFromAdmin.getCookingTime());
        dish.setPrice(dishFromAdmin.getPrice());
        dish.setWeight(dishFromAdmin.getWeight());
        dish.setKitchen(dishFromAdmin.getKitchen());
        dish.setDeleted(false);
        dish.setDishType(dishFromAdmin.getDishType());
        dish.setMainIngredient(dish.getMainIngredient());
        return dishRepository.save(dish).getId();
    }

    public Dish getDish(Long id) {
        return dishRepository.getById(id);
    }

    public void deleteDish(Long id) {
        Dish dish = dishRepository.getById(id);
        dish.setDeleted(true);
        dishRepository.save(dish);
    }

    public List<Dish> findAll() {
        List<Dish> allDishes = dishRepository.findAllOrder();
        return allDishes;
    }

    public double correlWithPrice(String param) {
        double correl = 0;
        List<Dish> dishList = findAll();
        int dishListSize = dishList.size();
        double y = 0;
        double firstSqrSum = 0;
        double priceSqrSum = 0;
        if (param.equals("cooking_time")) {
            for (Dish d : dishList) {
                y += (double) d.getCookingTime() * d.getPrice().doubleValue();
                firstSqrSum += Math.pow((double) d.getCookingTime(), 2);
                priceSqrSum += Math.pow(d.getPrice().doubleValue(), 2);
            }
            correl = y / Math.sqrt(firstSqrSum * priceSqrSum);
        } else if (param.equals("weight")) {
            for (Dish d : dishList) {
                y += (double) d.getWeight() * d.getPrice().doubleValue();
                firstSqrSum += Math.pow(d.getWeight(), 2);
                priceSqrSum += Math.pow(d.getPrice().doubleValue(), 2);
            }
            correl = y / Math.sqrt(firstSqrSum * priceSqrSum);
        } else if (param.equals("dish_type")) {
            String[] avgPriceOfSameTypes = dishRepository.findGroupedAvgType();
            for (int i = 0; i < dishListSize; i++) {
                for (int j = 0; j < avgPriceOfSameTypes.length; j++) {
                    if (dishList.get(i).getDishType().equals(avgPriceOfSameTypes[j])) {
                        firstSqrSum += Math.pow(j + 1, 2);
                    }
                }
            }
            correl = 1 - 6 * (firstSqrSum) / (dishListSize * (Math.pow(dishListSize, 2) - 1));

        } else if (param.equals("main_ingredient")) {
            String[] avgPriceOfMainIngredients = dishRepository.findGroupedAvgIngredient();
            for (int i = 0; i < dishListSize; i++) {
                for (int j = 0; j < avgPriceOfMainIngredients.length; j++) {
                    if (dishList.get(i).getMainIngredient().equals(avgPriceOfMainIngredients[j])) {
                        firstSqrSum += Math.pow(j + 1, 2);
                    }
                }
            }
            correl = 1 - 6 * (firstSqrSum) / (dishListSize * (Math.pow(dishListSize, 2) - 1));
        }
        return correl;
    }

    public double[][] distanceBetweenValues(String param) {
        int size = findAll().size();
        double[][] distance = new double[size][size];
        List<Dish> dishList = findAll();
        int rangeWeight = dishRepository.getMaxWeight() - dishRepository.getMinWeight();
        int rangeCookingType = dishRepository.getMaxCookingTime() - dishRepository.getMinCookingTime();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (param.equals("weight"))
                    distance[i][j] = (Math.abs(dishList.get(i).getWeight() - dishList.get(j).getWeight())) / (double) rangeWeight;
                else if (param.equals("cooking_time"))
                    distance[i][j] = Math.abs(dishList.get(i).getCookingTime() - dishList.get(j).getCookingTime()) / (double) rangeCookingType;
            }
        }

        return distance;
    }

    public ArrayList<Dish> getSame(int id, int n) {
        Dish mainDish = dishRepository.findById(id);
        ArrayList<Dish> sameDishes = new ArrayList<>();
        double[] distance = distanceBetweenDishes(id);

        ArrayList<Dish> dishWithSameTypeOrIngr =
                (ArrayList<Dish>) dishRepository.findDishWithSameTypeOrIngr(mainDish.getDishType(),
                        mainDish.getMainIngredient());
        if (dishWithSameTypeOrIngr.size() <= n) {
            for (Dish i : dishWithSameTypeOrIngr) {
                sameDishes.add(i);
            }
            ArrayList<Dish> otherDishes = (ArrayList<Dish>) dishRepository.findOtherDishes(mainDish.getDishType(), mainDish.getMainIngredient());
            ArrayList<Dish> sameOtherDishes = findSameDishes(distance, otherDishes, n - dishWithSameTypeOrIngr.size());
            for (Dish i : sameOtherDishes) {
                sameDishes.add(i);
            }
            return sameDishes;
        } else {
            ArrayList<Dish> sameOtherDishes = findSameDishes(distance, dishWithSameTypeOrIngr, n + 1);
            for (Dish i : sameOtherDishes) {
                sameDishes.add(i);
            }
            return sameDishes;
        }
    }

    public double[] distanceBetweenDishes(long id) {
        double[] weightDistance = distanceBetweenValues("weight")[(int) (id - 1)];
        double[] cookingTimeDistance = distanceBetweenValues("cooking_time")[(int) (id - 1)];
        double correlWeight = correlWithPrice("weight");
        double correlCookingTime = correlWithPrice("cooking_time");
        double[] distance = new double[weightDistance.length];
        for (long i = 0; i < weightDistance.length; i++) {
            distance[(int) i] = correlWeight * weightDistance[(int) i] + correlCookingTime * cookingTimeDistance[(int) i];
        }
        return distance;
    }

    public ArrayList<Dish> findSameDishes(double[] distance, ArrayList<Dish> dishes, int count) {
        ArrayList<Dish> sameDishes = new ArrayList();

        long[] indexes = new long[distance.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i + 1;
        }

        for (int i = distance.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (distance[j] >= distance[j + 1]) {
                    distance[j] = distance[j] + distance[j + 1];
                    distance[j + 1] = distance[j] - distance[j + 1];
                    distance[j] = distance[j] - distance[j + 1];
                    indexes[j] = indexes[j] + indexes[j + 1];
                    indexes[j + 1] = indexes[j] - indexes[j + 1];
                    indexes[j] = indexes[j] - indexes[j + 1];
                }
            }
        }

        for (int i = 0; i < indexes.length; i++) {
            for (int j = 0; j < dishes.size(); j++) {
                if (indexes[i] == dishes.get(j).getId() && sameDishes.size() < count) {
                    sameDishes.add(dishes.get(j));
                }
            }
        }

        return sameDishes;
    }


}

