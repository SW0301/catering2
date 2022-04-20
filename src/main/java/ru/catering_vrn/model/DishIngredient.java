package ru.catering_vrn.model;


import javax.persistence.*;

@Entity
@Table(name="dish_ingredient", schema = "public")
public class DishIngredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient_id;

    public Dish getDish_id() {
        return dish_id;
    }

    public void setDish_id(Dish dish_id) {
        this.dish_id = dish_id;
    }

    public Ingredient getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Ingredient ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
