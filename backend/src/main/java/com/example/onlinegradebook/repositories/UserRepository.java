package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

}