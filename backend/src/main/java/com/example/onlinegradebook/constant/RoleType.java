package com.example.onlinegradebook.constant;

public enum RoleType {
    STUDENT("STUDENT"), PARENT("PARENT"), TEACHER("TEACHER"), DIRECTOR("DIRECTOR"), ADMIN("ADMIN");

    private String roleName;

    private RoleType(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
