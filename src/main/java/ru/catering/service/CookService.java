package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.Cook;
import ru.catering.repository.CookRepository;

@Service
public class CookService {
    private final CookRepository cookRepository;

    public CookService(CookRepository cookRepository) {
        this.cookRepository = cookRepository;
    }

    public Long createCook(Cook cookFromAdmin){
        Cook cook = new Cook();
        cook.setGrade(cookFromAdmin.getGrade());
        cook.setGettingStarted(cookFromAdmin.getGettingStarted());
        cook.setRating(cookFromAdmin.getRating());
        cook.setAbout(cookFromAdmin.getAbout());
        cookRepository.save(cook);
        return cook.getId();
    }

    public Cook getCook(Long id){
        return cookRepository.getById(id);
    }

}
