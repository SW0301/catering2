package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.catering.model.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {


    @Query("SELECT distinct(d.dishType) FROM Dish as d")
    public List<String> selectUnique();

    @Query("SELECT d.dishType FROM Dish as d group BY d.dishType order by avg(d.price)")
    public String[] findGroupedAvgType();

    @Query("SELECT d.mainIngredient FROM Dish as d group BY d.mainIngredient order by avg(d.price)")
    public String[] findGroupedAvgIngredient();
}
