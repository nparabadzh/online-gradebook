package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.SchoolSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolScheduleRepository extends JpaRepository<SchoolSchedule, Integer>  {
}
