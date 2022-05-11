package com.example.onlinegradebook.model;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false)
    private Year year;

    @Column(name = "class")
    private Class classes;

    public Student() {
    }

    public Student(String name, String EGN, String address, int role, Year year, Class classes) {
        super(name, EGN, address, role);
        this.year = year;
        this.classes = classes;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }
}
