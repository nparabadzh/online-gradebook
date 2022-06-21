package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;

import javax.persistence.*;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String EGN;

    @Column(length = 200)
    private String address;

    @Column(name = "role")
    private RoleType role;

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
        return id;
    }
}
