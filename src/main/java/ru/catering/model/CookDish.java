package ru.catering.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "cook_dish", schema = "public")
public class CookDish {

    @EmbeddedId
    private CrossId cookDishId;
    @ManyToOne
    @JoinColumn(name = "cook_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Cook cook;
    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id", insertable = false, updatable = false)
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

    @Data
    @Embeddable
    public static class CrossId implements Serializable {
        private Long cook_id;

        private Long dish_id;
    }
}
