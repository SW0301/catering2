package ru.catering.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cook_kitchen", schema = "public")
public class CookKitchen {

    @Data
    @Embeddable
    public static class CrossId implements Serializable{
        private Long cook_id;

        private Long kitchen_id;
    }

    @EmbeddedId
    private CrossId cookKitchenId;

    @ManyToOne
    @JoinColumn(name = "cook_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Cook cook;

    @ManyToOne
    @JoinColumn(name = "kitchen_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Kitchen kitchen;

    public CrossId getCookKitchenId() {
        return cookKitchenId;
    }

    public void setCookKitchenId(CrossId cookKitchenId) {
        this.cookKitchenId = cookKitchenId;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
