package ru.catering.model;

import javax.persistence.*;

@Entity
@Table(name="cook_kitchen", schema = "public")
public class CookKitchen {

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook;

    @Id
    @ManyToOne
    @JoinColumn(name = "kitchen_id")
    private Kitchen kithcen;

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public Kitchen getKithcen() {
        return kithcen;
    }

    public void setKithcen(Kitchen kithcen) {
        this.kithcen = kithcen;
    }
}
