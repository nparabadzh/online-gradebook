package com.example.onlinegradebook.model;

public class Schools {
    int schoolID;
    String name;
    String address;

    public Schools() {
    }

    public Schools(int schoolID, String name, String address) {
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
