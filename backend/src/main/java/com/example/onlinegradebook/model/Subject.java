package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.Year;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Employee> teachers;

    @OneToMany
    private List<Topic> topics;

    @Column(name = "intended_for")
    private Year intendedFor;

    public Subject() {
        this.teachers = new ArrayList<>();
        this.topics = new ArrayList<>();
    }

    public Subject(Year intendedFor) {
        this.teachers = new ArrayList<>();
        this.topics = new ArrayList<>();
        this.intendedFor = intendedFor;
    }

    public Subject(List<Employee> teachers, List<Topic> topics, Year intendedFor) {
        this.teachers = teachers;
        this.topics = topics;
        this.intendedFor = intendedFor;
    }

    public List<Employee> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Employee> teachers) {
        this.teachers = teachers;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Year getIntendedFor() {
        return intendedFor;
    }

    public void setIntendedFor(Year intendedFor) {
        this.intendedFor = intendedFor;
    }

    public int getID(){
        return id;
    }
}
