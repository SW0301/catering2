package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.CookKitchen;

public interface CookKitchenRepository extends JpaRepository<CookKitchen, Long> {
}
