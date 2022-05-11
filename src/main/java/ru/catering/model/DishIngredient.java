package ru.catering.model;


import javax.persistence.*;

@Entity
@Table(name="dish_ingredient", schema = "public")
public class DishIngredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

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
}
