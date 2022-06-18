package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.Studies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudiesRepository extends JpaRepository<Studies, Integer> {
}
