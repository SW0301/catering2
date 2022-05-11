package ru.catering.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cook_dish", schema = "public")
public class CookDish {

    @Data
    @Embeddable
    public static class CrossId implements Serializable{
        private Long cook_id;

        private Long dish_id;
    }

    @EmbeddedId
    private CrossId cookDishId;


    @ManyToOne
    @JoinColumn(name = "cook_id", referencedColumnName = "id")
    private Cook cook;


    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dish dish;

    public CrossId getCookDishId() {
        return cookDishId;
    }

    public void setCookDishId(CrossId cookDishId) {
        this.cookDishId = cookDishId;
    }

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
