package com.example.jbl.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.jbl.model.CcspCourse;
import com.example.jbl.repository.CcspCourseRepository;

@Service
public class CcspCourseService {
    private final CcspCourseRepository repository;

    public CcspCourseService(CcspCourseRepository repository) {
        this.repository = repository;
    }

    // get all ccspCourses
    public List<CcspCourse> getAllCcspCourse() {
        return repository.findAll();
    }

    // get a specific ccsp with all it's courses
    public List<CcspCourse> getCcspWithCourses(Long code) {
        return repository.findByCcsp_Code(code);
    }

    // does the ccsp really exist
    public Boolean ccspHasCourses(Long code) {
        return repository.existsByCcsp_code(code);
    }
}
