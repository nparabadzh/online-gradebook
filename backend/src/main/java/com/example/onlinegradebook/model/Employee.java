package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee extends User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "qualification")
    String qualification;

    @Column(name = "salary")
    double salary;

    public Employee() {
    }

    public Employee(String name, String EGN, String address, RoleType role, String qualification, double salary) {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getID(){
        return id;
    }


}
