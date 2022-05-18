package com.example.onlinegradebook.repository;

import com.example.onlinegradebook.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findByUserName(String userName);
}
