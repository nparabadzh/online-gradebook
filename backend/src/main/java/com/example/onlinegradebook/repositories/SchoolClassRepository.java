package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Integer> {
}
