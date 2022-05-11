package com.example.onlinegradebook.model;

import java.util.ArrayList;
import java.util.List;

public class Parents extends User{
    List<Student> children;

    public Parents() {
        this.children = new ArrayList<>();
    }

    public Parents(String name, String EGN, String address, int role, List<Student> children) {
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
