package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepository extends JpaRepository<Grades, Integer> {
}
