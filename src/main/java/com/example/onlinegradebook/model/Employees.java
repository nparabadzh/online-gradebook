package com.example.onlinegradebook.model;

public class Employees extends Users {
    String qualification;
    String salary;

    public Employees() {
    }

    public Employees(String name, String EGN, String address, int role, String qualification, String salary) {
        super(name, EGN, address, role);
        this.qualification = qualification;
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }


}
