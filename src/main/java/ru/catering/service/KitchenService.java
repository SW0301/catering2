package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.Kitchen;
import ru.catering.repository.KitchenRepository;
@Service

public class KitchenService {
    private final KitchenRepository kitchenRepository;

    public KitchenService(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    public Long createKitchen(Kitchen kitchenFromAdmin){
        Kitchen kitchen = new Kitchen();
        kitchen.setName(kitchenFromAdmin.getName());
        kitchen.setDeleted(false);
        kitchenRepository.save(kitchen);
        return kitchen.getId();
    }

    public Kitchen getKitchen(Long id){
        return kitchenRepository.getById(id);
    }

    public void deleteKitchen(Long id){
        Kitchen kitchen = kitchenRepository.getById(id);
        kitchen.setDeleted(true);
        kitchenRepository.save(kitchen);
    }
}
