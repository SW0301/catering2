package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.Kitchen;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
