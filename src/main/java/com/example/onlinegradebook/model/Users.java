package com.example.onlinegradebook.model;

public class Users {
    String name;
    String EGN;
    String address;
    int role;

    public Users() {
    }

    public Users(String name, String EGN, String address, int role) {
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
