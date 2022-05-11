package ru.catering.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="dish", schema = "public")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column  (name = "name")
    private String name;

    @Column(name = "cooking_time")
    private short cookingTime;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "weight")
    private short weight;

    @ManyToOne
    @Column(name = "kitchen_id")
    private Kitchen kitchen;

    @Column(name = "is_deleted")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(short cookingTime) {
        this.cookingTime = cookingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
