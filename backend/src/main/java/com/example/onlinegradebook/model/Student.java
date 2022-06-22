package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.ClassInitialization;
import com.example.onlinegradebook.constant.RoleType;
import com.example.onlinegradebook.constant.Year;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "class_id", nullable = false)
    SchoolClass schoolClass;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    @ManyToOne
    Grades grades;

    public Student() {
    }

    public Student(User user, SchoolClass schoolClassIn, Grades grades) {
        this.user = user;
        this.schoolClass = schoolClassIn;
        this.grades = grades;
    }

    public int getID(){
        return id;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
