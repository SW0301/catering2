package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.Cook;
import ru.catering.model.CookKitchen;

import ru.catering.repository.CookKitchenRepository;


@Service
public class CookKitchenService {

    private final CookKitchenRepository cookKitchenRepository;

    public CookKitchenService(CookKitchenRepository cookKitchenRepository) {
        this.cookKitchenRepository = cookKitchenRepository;
    }

    public void createCookKitchen(CookKitchen cookKitchenFromAdmin){
        CookKitchen cookKitchen = new CookKitchen();
        cookKitchen.setCook(cookKitchenFromAdmin.getCook());
        cookKitchen.setKitchen(cookKitchenFromAdmin.getKitchen());
    }
}
