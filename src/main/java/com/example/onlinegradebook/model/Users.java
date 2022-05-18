package com.example.onlinegradebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    String name;
    String EGN;
    String address;
    int role;
    Set<Role> roles;

}
