package ru.catering.model;

import javax.persistence.*;

@Entity
@Table(name="cook_dish", schema = "public")
public class CookDish {

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cookId;

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dishId;


    public Cook getCookId() {
        return cookId;
    }

    public void setCookId(Cook cookId) {
        this.cookId = cookId;
    }

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }
}
