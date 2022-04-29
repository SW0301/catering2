package ru.catering.model;

import javax.persistence.*;

@Entity
@Table(name="grade", schema = "public")
public class Grade  extends General{
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
