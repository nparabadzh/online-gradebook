package com.example.onlinegradebook.model;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee extends User {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Integer id;

    @Column(name = "qualification")
    String qualification;

    @Column(name = "salary")
    String salary;

    public Employee() {
    }

    public Employee(String name, String EGN, String address, int role, String qualification, String salary) {
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
