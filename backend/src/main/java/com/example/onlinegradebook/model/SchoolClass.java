package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.ClassInitialization;
import com.example.onlinegradebook.constant.Year;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="classes")
public class SchoolClass {

    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    Year year;

    @Column(name = "class")
    ClassInitialization classInitialization;

    @OneToMany
    List<Student> students;

    @OneToMany
    List<Subject> subjects;

    public SchoolClass() {
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();

    }

    public SchoolClass(Year year, ClassInitialization classInitialization, List<Student> students, List<Subject> subjects) {
        this.year = year;
        this.classInitialization = classInitialization;
        this.students = students;
        this.subjects = subjects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public ClassInitialization getClassInitialization() {
        return classInitialization;
    }

    public void setClassInitialization(ClassInitialization classInitialization) {
        this.classInitialization = classInitialization;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
