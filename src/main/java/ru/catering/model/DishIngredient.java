package ru.catering.model;


import javax.persistence.*;

@Entity
@Table(name="dish_ingredient", schema = "public")
public class DishIngredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dishId;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredientId;

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }

    public Ingredient getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Ingredient ingredientId) {
        this.ingredientId = ingredientId;
    }
}
