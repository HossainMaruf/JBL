package com.example.jbl.controller;

import java.util.List;
import com.example.jbl.model.Course;
import com.example.jbl.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
   private final CourseService service; 
   public CourseController(CourseService service) {
    this.service = service;
   }

   // GET all courses
   @GetMapping
   public List<Course> getAllCourses() { return service.getAllCourses(); }

   // GET course by code
   @GetMapping("/{code}")
   public ResponseEntity<Course> getCourseByCode(@PathVariable String code) {
    return service.getCourseByCode(code)
                  .map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
   }

   // POST create course
   @PostMapping
   public Course createCourse(@RequestBody Course course) {
    return service.saveCourse(course);
   }

   // PUT update course
   @PutMapping("/{code}")
   public ResponseEntity<Course> updateCourse(@PathVariable String code, @RequestBody Course updatedCourse) {
        return service.getCourseByCode(code).map(course -> {
            course.setCode(updatedCourse.getCode());
            course.setTitle(updatedCourse.getTitle());
            course.setCredit(updatedCourse.getCredit());
            course.setType(updatedCourse.getType());
            service.saveCourse(course);
            return ResponseEntity.ok(course);
        }).orElse(ResponseEntity.notFound().build());
   }

   // DELETE course
   @DeleteMapping("/{code}")
   public ResponseEntity<String> deleteCourse(@PathVariable String code) {
    return service.getCourseByCode(code).map(course -> {
        service.deleteCourse(code);
        return ResponseEntity.ok("Deleted course with code " + code);
    }).orElse(ResponseEntity.notFound().build());
   }
}
