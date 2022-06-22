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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Year year;

    @Column(name = "class")
    private ClassInitialization classes;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    School school;

    @OneToMany
    List<Student> students;

    public SchoolClass() {
        this.students = new ArrayList<>();
    }

    public SchoolClass(Year year, ClassInitialization classes, School school, List<Student> students, List<Subject> subjects) {
        this.year = year;
        this.classes = classes;
        this.school = school;
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
