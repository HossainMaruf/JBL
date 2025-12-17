package com.example.jbl.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.jbl.model.Course;
import com.example.jbl.repository.CourseRepository;

@Service
public class CourseService {
   private final CourseRepository repository; 
   public CourseService(CourseRepository repository) {
    this.repository = repository;
   }

   // get all courses
   public List<Course> getAllCourses() {
    return repository.findAll();
   }

   // get course by code
   public Optional<Course> getCourseByCode(String code) {
    return repository.findById(code);
   }

   // create or update course
   public Course saveCourse(Course course) {
    return repository.save(course);
   }

   // delete course by code
   public void deleteCourse(String code) {
    repository.deleteById(code);
   }

}
