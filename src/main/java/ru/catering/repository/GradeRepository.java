package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
