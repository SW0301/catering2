package ru.catering.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "order_dish", schema = "public")
public class OrderDish {


    @EmbeddedId
    private CrossId orderDishId;
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

    public CrossId getOrderDishId() {
        return orderDishId;
    }

    public void setOrderDishId(CrossId orderDishId) {
        this.orderDishId = orderDishId;
    }

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

    @Data
    @Embeddable
    public static class CrossId implements Serializable {
        private Long order_id;
        private Long dish_id;
        private Long cook_id;
    }
}
