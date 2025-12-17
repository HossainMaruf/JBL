package com.example.jbl.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.jbl.model.Department;
import com.example.jbl.repository.DepartmentRepository;

@Service
public class DepartmentService {
   private final DepartmentRepository repository; 
   public DepartmentService(DepartmentRepository repository) {
    this.repository = repository;
   }

   // get all departments
   public List<Department> getAllDepartments() {
    return repository.findAll();
   }

   // get department by code
   public Optional<Department> getDepartmentByCode(String code) {
    return repository.findById(code);
   }

   // create or update department
   public Department saveDepartment(Department department) {
    return repository.save(department);
   }

   // delete department by code
   public void deleteDepartment(String code) {
    repository.deleteById(code);
   }
}