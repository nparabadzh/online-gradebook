package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Employee> teachers;

    @OneToMany
    private List<Topic> topics;

    @ManyToMany
    private List<Student> students;

    @Column(name = "intended_for")
    private Year intendedFor;

    public Subjects() {
        this.teachers = new ArrayList<>();
        this.topics = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Subjects(Year intendedFor) {
        this.teachers = new ArrayList<>();
        this.topics = new ArrayList<>();
        this.students = new ArrayList<>();
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Year getIntendedFor() {
        return intendedFor;
    }

    public void setIntendedFor(Year intendedFor) {
        this.intendedFor = intendedFor;
    }
}
