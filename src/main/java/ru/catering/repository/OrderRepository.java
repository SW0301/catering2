package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
