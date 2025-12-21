package com.example.jbl.controller;

import java.util.List;
import com.example.jbl.model.Ccsp;
import com.example.jbl.model.Department;
import com.example.jbl.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    // GET all departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

    // GET department by code
    @GetMapping("/{code}")
    public ResponseEntity<Department> getAccountById(@PathVariable String code) {
        return service.getDepartmentByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new department
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return service.saveDepartment(department);
    }

    // PUT update department
    @PutMapping("/{code}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String code,
            @RequestBody Department updatedDepartment) {
        return service.getDepartmentByCode(code)
                .map(department -> {
                    department.setCode(updatedDepartment.getCode());
                    department.setName(updatedDepartment.getName());
                    department.setAbbreviation(updatedDepartment.getName());
                    service.saveDepartment(department);
                    return ResponseEntity.ok(department);
                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE account
    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteAccount(@PathVariable String code) {
        return service.getDepartmentByCode(code)
        .map(department -> {
            service.deleteDepartment(code);
            return ResponseEntity.ok("Deleted department with code "+code);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    // GET all ccsps of a particular department
    // @GetMapping("/{code}/ccsps")
    // public ResponseEntity<List<Ccsp>> getCcspsOfDepartment(@PathVariable String code) {
    //     return service.getDepartmentByCode(code)
    //         .map(department -> ResponseEntity.ok(department.getCcsps()))
    //         .orElseGet(() -> ResponseEntity.notFound().build());
    // }
}