package ru.catering.model.directory;

import javax.persistence.*;

@MappedSuperclass
public abstract class General {

    @Column(name = "name")
    protected String name;
    @Column(name = "is_deleted")
    protected boolean deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
