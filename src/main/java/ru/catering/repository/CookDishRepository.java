package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.CookDish;

public interface CookDishRepository extends JpaRepository<CookDish, Long> {
}
