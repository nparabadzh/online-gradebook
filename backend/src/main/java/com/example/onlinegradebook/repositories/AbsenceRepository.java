package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
}
