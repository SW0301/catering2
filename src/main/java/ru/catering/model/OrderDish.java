package ru.catering.model;


import javax.persistence.*;


@Table(name="order_dish", schema = "public")
public class OrderDish {


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;


    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dishId;


    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cookId;

    @Column(name = "count")
    private short count;

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }

    public Cook getCookId() {
        return cookId;
    }

    public void setCookId(Cook cookId) {
        this.cookId = cookId;
    }

    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }
}
