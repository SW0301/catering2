package ru.catering.model;


import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="cook", schema = "public")
public class Cook {

    @Id
    @Column (name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="grade_id")
    private Grade grade;

    @Temporal(TemporalType.DATE)
    @Column(name="getting_started")
    private Date gettingStarted;

    @Column(name="rating")
    private double rating;

    @Column(name="about")
    private String about;

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
