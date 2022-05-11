package com.example.onlinegradebook.model;

public class Students extends User {
    Year year;
    Classes classes;

    public Students() {
    }

    public Students(String name, String EGN, String address, int role, Year year, Classes classes) {
        super(name, EGN, address, role);
        this.year = year;
        this.classes = classes;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
