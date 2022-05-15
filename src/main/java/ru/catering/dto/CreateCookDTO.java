package ru.catering.dto;

import ru.catering.model.Cook;

public class CreateCookDTO {

    private Cook cook;

    private Long userId;

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
