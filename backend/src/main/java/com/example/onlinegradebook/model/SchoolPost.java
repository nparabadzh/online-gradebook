package com.example.onlinegradebook.model;

import java.util.List;

public class SchoolPost {

    private String name;

    private String address;

    private List<SchoolClass> classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<SchoolClass> getClasses() {
        return classes;
    }

    public void setClasses(List<SchoolClass> classes) {
        this.classes = classes;
    }

}
