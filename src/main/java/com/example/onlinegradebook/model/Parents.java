package com.example.onlinegradebook.model;

import java.util.ArrayList;
import java.util.List;

public class Parents extends Users{
    List<Students> children;

    public Parents() {
        this.children = new ArrayList<>();
    }

    public Parents(String name, String EGN, String address, int role, List<Students> children) {
        super(name, EGN, address, role);
        this.children = new ArrayList<>();
    }

    public List<Students> getChildren() {
        return children;
    }

    public void setChildren(List<Students> children) {
        this.children = children;
    }
}
