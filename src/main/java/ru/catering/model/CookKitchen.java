package ru.catering.model;

import javax.persistence.*;

@Entity
@Table(name="cook_kitchen", schema = "public")
public class CookKitchen {

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cookId;

    @Id
    @ManyToOne
    @JoinColumn(name = "kitchen_id")
    private Kitchen kithcenId;

    public Cook getCookId() {
        return cookId;
    }

    public void setCookId(Cook cookId) {
        this.cookId = cookId;
    }

    public Kitchen getKithcenId() {
        return kithcenId;
    }

    public void setKithcenId(Kitchen kithcenId) {
        this.kithcenId = kithcenId;
    }
}
