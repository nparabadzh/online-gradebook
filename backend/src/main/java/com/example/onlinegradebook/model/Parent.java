package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parents")
public class Parent{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()@JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @OneToOne @JoinColumn(name = "user_id", nullable = true)
    private User user;

    public Parent() {

    }

    public Parent(User user, Student student) {
        this.student = student;
        this.user = user;
    }

    public Student getChildren() {
        return student;
    }

    public void setChildren(Student student) {
        this.student = student;
    }

    public int getID(){
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
