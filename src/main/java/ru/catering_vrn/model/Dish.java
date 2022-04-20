package ru.catering_vrn.model;

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
    private short cooking_time;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "weight")
    private short weight;

    @ManyToOne
    @Column(name = "kitchen_id")
    private Kitchen kitchen_id;

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

    public short getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(short cooking_time) {
        this.cooking_time = cooking_time;
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

    public Kitchen getKitchen_id() {
        return kitchen_id;
    }

    public void setKitchen_id(Kitchen kitchen_id) {
        this.kitchen_id = kitchen_id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
