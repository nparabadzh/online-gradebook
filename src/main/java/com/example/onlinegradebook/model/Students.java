package com.example.onlinegradebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Students extends Users {

    Year year;
    Classes classes;

}
