package ru.catering.model;


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
    private Grade gradeId;

    @Column(name="getting_started")
    private String gettingStarted;

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

    public Grade getGradeId() {
        return gradeId;
    }

    public void setGradeId(Grade gradeId) {
        this.gradeId = gradeId;
    }

    public String getGettingStarted() {
        return gettingStarted;
    }

    public void setGettingStarted(String gettingStarted) {
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
