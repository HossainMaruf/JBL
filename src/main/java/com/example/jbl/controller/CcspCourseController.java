package com.example.jbl.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.jbl.model.CcspCourse;
import com.example.jbl.service.CcspCourseService;

@RestController
@RequestMapping("/api/ccsp")
public class CcspCourseController {
    private final CcspCourseService service;

    public CcspCourseController(CcspCourseService service) {
        this.service = service;
    }

    // GET all ccspCourses
    @GetMapping
    public List<CcspCourse> getAllCcspCourse() {
        return service.getAllCcspCourse();
    }

    @GetMapping("/{code}/courses")
    public ResponseEntity<List<CcspCourse>> getCcspWithCourses(@PathVariable Long code) {
        if(service.ccspHasCourses(code)) {

            return ResponseEntity.ok(service.getCcspWithCourses(code));
        }
        return ResponseEntity.notFound().build();
    }
}
