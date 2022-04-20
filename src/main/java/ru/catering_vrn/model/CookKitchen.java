package ru.catering_vrn.model;

import javax.persistence.*;

@Entity
@Table(name="cook_kitchen", schema = "public")
public class CookKitchen {

    @Id
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "kitchen_id")
    private Kitchen kithcen_id;

    public Cook getCook_id() {
        return cook_id;
    }

    public void setCook_id(Cook cook_id) {
        this.cook_id = cook_id;
    }

    public Kitchen getKithcen_id() {
        return kithcen_id;
    }

    public void setKithcen_id(Kitchen kithcen_id) {
        this.kithcen_id = kithcen_id;
    }
}
