package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


}
