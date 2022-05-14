package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.DishIngredient;

public interface DishIngredientRepository extends JpaRepository<DishIngredient, Long> {
}
