package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String EGN;

    @Column(length = 200)
    private String address;

    @Column(name = "role")
    private RoleType role;

//    @OneToOne(mappedBy = "user")
//    private Employee employee;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Student student;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Parent parent;

    public User() {
    }

    public User(String name, String EGN, String address, RoleType role) {
        this.name = name;
        this.EGN = EGN;
        this.address = address;
        this.role = role;
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

    public int getID(){
        return userId;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Parent getParent() {
//        return parent;
//    }
//
//    public void setParent(Parent parent) {
//        this.parent = parent;
//    }
}
