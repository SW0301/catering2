package ru.catering.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.catering.model.directory.Grade;

import java.util.Date;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "cook", schema = "public")
public class Cook {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "about")
    private String about;

    @Temporal(TemporalType.DATE)
    @Column(name = "getting_started")
    private Date gettingStarted;

    @Column(name = "rating")
    private double rating;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Date getGettingStarted() {
        return gettingStarted;
    }

    public void setGettingStarted(Date gettingStarted) {
        this.gettingStarted = gettingStarted;
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
