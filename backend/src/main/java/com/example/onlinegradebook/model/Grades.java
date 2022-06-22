package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="grades")
public class Grades {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Subject subject;

    @Column(name = "grade")
    private double grade;

    @Column(name = "date")
    private Date date;

    public Grades() {
    }

    public Grades(Subject subject, double grade, Date date) {
        this.subject = subject;
        this.grade = grade;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
