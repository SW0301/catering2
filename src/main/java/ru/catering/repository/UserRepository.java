package ru.catering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.catering.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
