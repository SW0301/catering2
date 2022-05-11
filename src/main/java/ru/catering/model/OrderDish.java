package ru.catering.model;


import javax.persistence.*;


@Table(name="order_dish", schema = "public")
public class OrderDish {


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;


    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook;

    @Column(name = "count")
    private short count;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }
}
