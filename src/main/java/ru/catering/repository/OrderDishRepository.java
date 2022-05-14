package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.OrderDish;

public interface OrderDishRepository extends JpaRepository<OrderDish, Long> {
}
