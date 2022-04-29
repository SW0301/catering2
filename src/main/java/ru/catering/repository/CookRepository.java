package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.Cook;

public interface CookRepository extends JpaRepository<Cook, Long> {
}
