package com.example.onlinegradebook.model;

import java.util.ArrayList;
import java.util.List;

public class Subjects {
    List<Employees> teachers;
    List<Topics> topics;
    List<Students> students;
    Year intendedFor;

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

    public List<Employees> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Employees> teachers) {
        this.teachers = teachers;
    }

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public Year getIntendedFor() {
        return intendedFor;
    }

    public void setIntendedFor(Year intendedFor) {
        this.intendedFor = intendedFor;
    }
}
