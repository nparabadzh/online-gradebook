package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query(value = "SELECT * FROM subjects s WHERE s.class_id = :class_id", nativeQuery = true)
    public List<Subject> getAllSubjectsForClassId(@Param("class_id") Integer classId);
}
