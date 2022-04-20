package ru.catering_vrn.model;

import javax.persistence.*;

@Entity
@Table(name="cook_dish", schema = "public")
public class CookDish {

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish_id;


    public Cook getCook_id() {
        return cook_id;
    }

    public void setCook_id(Cook cook_id) {
        this.cook_id = cook_id;
    }

    public Dish getDish_id() {
        return dish_id;
    }

    public void setDish_id(Dish dish_id) {
        this.dish_id = dish_id;
    }
}
