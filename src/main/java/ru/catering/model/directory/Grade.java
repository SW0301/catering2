package ru.catering.model.directory;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grade", schema = "public")
public class Grade extends General {
}