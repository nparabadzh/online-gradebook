package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, length = 100)
    String name;

    @Column(nullable = false, length = 10)
    String EGN;

    @Column(length = 200)
    String address;

    @Column(name = "role")
    RoleType role;

    @OneToOne(mappedBy = "user")
    Employee employee;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Student student;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Parent parent;

    public User() {
    }

    public User(String name, String EGN, String address, RoleType role, Employee employee, Student student, Parent parent) {
        this.name = name;
        this.EGN = EGN;
        this.address = address;
        this.role = role;
        this.employee = employee;
        this.student = student;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
