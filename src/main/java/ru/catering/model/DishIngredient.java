package ru.catering.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ru.catering.model.directory.Ingredient;

import java.io.Serializable;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "dish_ingredient", schema = "public")
public class DishIngredient {

    @EmbeddedId
    private CrossId dishIngredientId;
    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Dish dish;
    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Ingredient ingredient;

    public CrossId getDishIngredientId() {
        return dishIngredientId;
    }

    public void setDishIngredientId(CrossId dishIngredientId) {
        this.dishIngredientId = dishIngredientId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Data
    @Embeddable
    public static class CrossId implements Serializable {
        private Long dish_id;
        private Long ingredient_id;
    }
}
