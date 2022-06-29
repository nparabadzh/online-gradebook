package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;

public class UserPost {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String egn;

    private String address;

    private RoleType role;

    public UserPost() {
    }

//    public String getId() {
//        return id;
//    }

    public String getEmail() { return email; }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEgn() { return egn; }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}