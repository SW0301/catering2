package ru.catering_vrn.model;


import javax.persistence.*;

@Entity
@Table(name="cook", schema = "public")
public class Cook {

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    private Pguser id;

    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade_id;

    @Column(name="getting_started")
    private String getting_sterted;

    @Column(name="rating")
    private double rating;

    @Column(name="about")
    private String about;

    public Pguser getId() {
        return id;
    }

    public void setId(Pguser id) {
        this.id = id;
    }

    public Grade getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Grade grade_id) {
        this.grade_id = grade_id;
    }

    public String getGetting_sterted() {
        return getting_sterted;
    }

    public void setGetting_sterted(String getting_sterted) {
        this.getting_sterted = getting_sterted;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
