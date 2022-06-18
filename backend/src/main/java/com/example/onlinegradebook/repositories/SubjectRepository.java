package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
