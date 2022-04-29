package ru.catering.model;

import javax.persistence.*;

@Entity
@Table(name="kitchen", schema = "public")
public class Kitchen extends  General{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
