package com.example.jbl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jbl.model.CcspCourse;

public interface CcspCourseRepository extends JpaRepository<CcspCourse, Long> {
    // JpaRepository provides all CRUD methods automatically
}
