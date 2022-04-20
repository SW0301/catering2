package ru.catering_vrn.model;


import javax.persistence.*;

@Entity
@Table(name="order_dish", schema = "public")
public class OrederDish {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Pgorder order_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook_id;

    @Column(name = "count")
    private short count;

    public Pgorder getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Pgorder order_id) {
        this.order_id = order_id;
    }

    public Dish getDish_id() {
        return dish_id;
    }

    public void setDish_id(Dish dish_id) {
        this.dish_id = dish_id;
    }

    public Cook getCook_id() {
        return cook_id;
    }

    public void setCook_id(Cook cook_id) {
        this.cook_id = cook_id;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }
}
