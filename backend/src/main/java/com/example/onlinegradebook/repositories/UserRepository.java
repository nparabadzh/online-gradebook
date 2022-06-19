package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}