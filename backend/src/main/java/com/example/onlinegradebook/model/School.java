package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="schools")
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany (mappedBy =  "school", cascade = CascadeType.ALL)
    private  List<SchoolClass> classes;

    public School() {
        classes = new ArrayList<>();
    }

    public School(String name, String address, List<SchoolClass> classes) {
        this.name = name;
        this.address = address;
        this.classes = classes;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public List<SchoolClass> getEmployees() {
        return classes;
    }

    public void setEmployees(List<SchoolClass> classes) {
        this.classes = classes;
    }
}
