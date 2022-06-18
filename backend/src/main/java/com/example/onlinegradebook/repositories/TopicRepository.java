package com.example.onlinegradebook.repositories;

import com.example.onlinegradebook.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
