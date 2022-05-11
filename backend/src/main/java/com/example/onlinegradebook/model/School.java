package com.example.onlinegradebook.model;

import javax.persistence.*;

@Entity
@Table(name="schools")
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int schoolID;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    public School() {
    }

    public School(int schoolID, String name, String address) {
        this.schoolID = schoolID;
        this.name = name;
        this.address = address;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
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
}
