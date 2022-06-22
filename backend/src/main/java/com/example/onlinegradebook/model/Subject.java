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

    @OneToOne
    private Employee teacher;

    @ManyToOne
    private Topic topic;

    @Column(name = "intended_for")
    private Year intendedFor;

    public Subject() {

    }

    public Subject(Year intendedFor) {
        this.intendedFor = intendedFor;
    }

    public Subject(Employee teacher, Topic topic, Year intendedFor) {
        this.teacher = teacher;
        this.topic = topic;
        this.intendedFor = intendedFor;
    }

    public Employee getTeachers() {
        return teacher;
    }

    public void setTeachers(Employee teachers) {
        this.teacher = teacher;
    }

    public Topic getTopics() {
        return topic;
    }

    public void setTopics(Topic topics) {
        this.topic = topic;
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

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
