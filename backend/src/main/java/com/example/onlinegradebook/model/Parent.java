package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parents")
public class Parent extends User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    private List<Student> children;

    public Parent() {
        this.children = new ArrayList<>();
    }

    public Parent(String name, String EGN, String address, RoleType role, List<Student> children) {
        super(name, EGN, address, role);
        this.children = children;
    }

    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }

    public int getID(){
        return id;
    }
}
