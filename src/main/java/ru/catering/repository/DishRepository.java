package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.catering.model.Dish;


import java.util.List;


public interface DishRepository extends JpaRepository<Dish, Long> {


    @Query("SELECT distinct(d.dishType) FROM Dish as d")
    List<String> selectUnique();

    @Query("SELECT d.dishType FROM Dish as d group BY d.dishType order by avg(d.price)")
    String[] findGroupedAvgType();

    @Query("SELECT d.mainIngredient FROM Dish as d group BY d.mainIngredient order by avg(d.price)")
    String[] findGroupedAvgIngredient();

    @Query("select min(d.weight) from Dish as d ")
    int getMinWeight();

    @Query("select max(d.weight) from Dish as d ")
    int getMaxWeight();

    @Query("select min(d.cookingTime) from Dish as d ")
    int getMinCookingTime();

    @Query("select max(d.cookingTime) from Dish as d ")
    int getMaxCookingTime();

    @Query("SELECT dish FROM Dish as dish ORDER  BY dish.id")
    List<Dish> findAllOrder();

    @Query("SELECT dish FROM Dish as dish WHERE dish.id = :id")
    Dish findById(@Param("id") long id);

    @Query("SELECT d FROM Dish as d WHERE d.mainIngredient = :mainIngredient OR d.dishType = :dishType ORDER BY d.id")
    List<Dish> findDishWithSameTypeOrIngr(@Param("dishType") String dishType, @Param("mainIngredient") String mainIngredient);

    @Query("SELECT d FROM Dish as d WHERE d.mainIngredient <> :mainIngredient AND d.dishType <> :dishType ORDER BY d.id")
    List<Dish> findOtherDishes(@Param("dishType") String dishType, @Param("mainIngredient") String mainIngredient);

}
