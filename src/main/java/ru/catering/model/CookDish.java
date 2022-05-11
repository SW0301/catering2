package ru.catering.model;

import javax.persistence.*;

@Entity
@Table(name="cook_dish", schema = "public")
public class CookDish {

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook;

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;


    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
