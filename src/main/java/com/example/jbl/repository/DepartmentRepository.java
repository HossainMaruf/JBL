package com.example.jbl.repository;

import com.example.jbl.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{
    // JpaRepository provides all CRUD methods automatically
}
