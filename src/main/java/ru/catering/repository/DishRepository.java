package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {


}
