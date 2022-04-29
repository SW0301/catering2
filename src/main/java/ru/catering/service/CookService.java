package ru.catering.service;

import ru.catering.model.Cook;
import ru.catering.repository.CookRepository;

public class CookService {
    private final CookRepository cookRepository;

    public CookService(CookRepository cookRepository) {
        this.cookRepository = cookRepository;
    }

    public Long createCook(Cook cookFromAdmin){
        Cook cook = new Cook();
        cook.setGradeId(cookFromAdmin.getGradeId());
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
