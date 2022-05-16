package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.Cook;
import ru.catering.model.User;
import ru.catering.repository.CookRepository;
import ru.catering.repository.UserRepository;

@Service
public class CookService {

    private final CookRepository cookRepository;
    private final UserRepository userRepository;

    public CookService(CookRepository cookRepository, UserRepository userRepository) {
        this.cookRepository = cookRepository;
        this.userRepository = userRepository;
    }

    public Long createCook(Cook cookFromAdmin, Long userId) {
        User user = userRepository.getById(userId);
        Cook cook = new Cook();
        cook.setUser(user);
        cook.setGrade(cookFromAdmin.getGrade());
        cook.setGettingStarted(cookFromAdmin.getGettingStarted());
        cook.setRating(cookFromAdmin.getRating());
        cook.setAbout(cookFromAdmin.getAbout());
        return cookRepository.save(cook).getId();
    }

    public Cook getCook(Long id) {
        return cookRepository.getById(id);
    }
}
