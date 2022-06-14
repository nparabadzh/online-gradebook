package com.example.onlinegradebook.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parents")
public class Parent extends User{

    @ManyToMany
    private List<Student> children;

    public Parent() {
        this.children = new ArrayList<>();
    }

    public Parent(String name, String EGN, String address, int role, List<Student> children) {
        super(name, EGN, address, role);
        this.children = new ArrayList<>();
    }

    public List<Student> getChildren() {
        return children;
    }

    public void setChildren(List<Student> children) {
        this.children = children;
    }
}
