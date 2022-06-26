package com.example.onlinegradebook.model;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    ADMIN(1l, "ADMIN"),
    TEACHER(2l, "TEACHER"),
    STUDENT(3L, "STUDENT");

    private long id;
    private String name;

    Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String getRoleName(long id){
        for (Role role: Role.values()) {
            if (role.getId() == id){
                return role.getName();
            }
        }
        throw new IllegalArgumentException(String.format("Role with id: {0} is not found", id));
    }
}
