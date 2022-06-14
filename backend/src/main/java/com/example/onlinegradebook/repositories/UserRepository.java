package com.example.onlinegradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.onlinegradebook.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}