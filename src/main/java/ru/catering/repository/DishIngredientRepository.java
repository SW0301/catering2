package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.catering.model.DishIngredient;
@Repository
public interface DishIngredientRepository extends JpaRepository<DishIngredient, DishIngredient.CrossId> {
}
