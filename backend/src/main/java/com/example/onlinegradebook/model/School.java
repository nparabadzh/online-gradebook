package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="schools")
public class School {

    @Id
    @Column(name = "school_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @OneToMany (mappedBy =  "school", cascade = CascadeType.ALL)
    List<SchoolClass> classes;

    public School() {
        classes = new ArrayList<>();
    }

    public School(String name, String address, List<SchoolClass> classes) {
        this.name = name;
        this.address = address;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SchoolClass> getClasses() {
        return classes;
    }

    public void setClasses(List<SchoolClass> classes) {
        this.classes = classes;
    }

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


    public List<SchoolClass> getEmployees() {
        return classes;
    }

    public void setEmployees(List<SchoolClass> classes) {
        this.classes = classes;
    }
}
