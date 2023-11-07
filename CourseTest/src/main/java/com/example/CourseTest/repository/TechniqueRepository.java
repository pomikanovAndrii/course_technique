package com.example.CourseTest.repository;

import com.example.CourseTest.model.Technique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniqueRepository extends JpaRepository<Technique, Long> {
}
