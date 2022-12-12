package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.Dish;
import ru.catering.repository.DishRepository;

import java.util.List;

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

    public List<Dish> findAll(){
        List<Dish> allDishes = dishRepository.findAll();
        return allDishes;
    }

    public double correlWithPrice(String x){
        double correl=0;
        List<Dish> dishList = findAll();
        double y = 0;
        double firstSqrSum=0;
        double priceSqrSum=0;
        if(x.equals("cooking_time")){
            for(Dish d:dishList) {
                y += (double) d.getCookingTime() * d.getPrice().doubleValue();
                firstSqrSum += Math.pow((double) d.getCookingTime(),2);
                priceSqrSum += Math.pow(d.getPrice().doubleValue(),2);
            }
            correl=y/Math.sqrt(firstSqrSum*priceSqrSum);
        }
        else if(x.equals("weight")){
            for(Dish d:dishList) {
                y += (double) d.getWeight() * d.getPrice().doubleValue();
                firstSqrSum += Math.pow((double) d.getWeight(),2);
                priceSqrSum += Math.pow(d.getPrice().doubleValue(),2);
            }
            correl=y/Math.sqrt(firstSqrSum*priceSqrSum);
        }
        return correl;
    }
    public double[][] distanceBetweenValues(String param){
        double[][] distance = new double[findAll().size()-1][];
        int size=findAll().size()-1;
        for(int i=0; i<findAll().size()-1;i++){
            distance[i]=new double[size];
            size--;
        }
        for(int i = 0; i<findAll().size()-1; i++){
            for(int j=i+1; j<findAll().size();j++){
                if(param.equals("weight"))
                    distance[i][j-(i+1)]=Math.abs(findAll().get(i).getWeight()-findAll().get(j).getWeight());
                else if(param.equals("cooking_time"))
                    distance[i][j-(i+1)]=Math.abs(findAll().get(i).getCookingTime()-findAll().get(j).getCookingTime());
            }
        }

        return distance;
    }


}
//distance[i][j-(i+1)]=Math.sqrt(Math.pow(findAll().get(i).getWeight(),2)+Math.pow(findAll().get(j).getWeight(),2));