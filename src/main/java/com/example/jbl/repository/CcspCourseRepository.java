package com.example.jbl.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jbl.model.CcspCourse;

public interface CcspCourseRepository extends JpaRepository<CcspCourse, Long> {
    // This method is for joining of table by name of this method
    List<CcspCourse> findByCcsp_Code(Long ccspCode);
    Boolean existsByCcsp_code(Long ccspCode);
}
