package com.example.onlinegradebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinegradebook.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String> {
    RoleEntity findByName(String name);
}