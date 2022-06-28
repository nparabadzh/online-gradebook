package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);

    Boolean existsByEmail(String email);
}