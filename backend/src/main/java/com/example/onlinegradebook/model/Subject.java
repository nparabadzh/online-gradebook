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
    int id;

    @Column(name = "subject_name")
    String subject_name;

    @OneToOne
    Employee teacher;

    @OneToMany
    List<Topic> topics;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    SchoolClass schoolClass;

    @OneToMany
    @JoinColumn(name = "student_id", nullable = true)
    List<Grades> grades;

    public Subject() {
    }

    public Subject(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Subject(String subject_name, Employee teacher, List<Topic> topics, SchoolClass schoolClass) {
        this.subject_name = subject_name;
        this.teacher = teacher;
        this.topics = topics;
        this.schoolClass = schoolClass;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
}
