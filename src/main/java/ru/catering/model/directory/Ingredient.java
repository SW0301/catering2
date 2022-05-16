package ru.catering.model.directory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient", schema = "public")
public class Ingredient extends General {

    @Column(name = "category")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}