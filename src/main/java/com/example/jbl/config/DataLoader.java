package com.example.jbl.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.github.javafaker.Faker;
import com.example.jbl.model.Ccsp;
import com.example.jbl.model.Course;
import com.example.jbl.model.CourseType;
import com.example.jbl.model.Department;
import com.example.jbl.repository.CcspRepository;
import com.example.jbl.repository.CourseRepository;
import com.example.jbl.repository.DepartmentRepository;

@Configuration
public class DataLoader {
   private List<Department> departments = new ArrayList<Department>();
   @Bean
   @Order(1)
   CommandLineRunner loadFakeCourses(CourseRepository courseRepository) {
        return args -> {
            Faker faker = new Faker();
            Random random = new Random();

            for(int i=0; i<20; i++) {
                String code = "CSE" + (100+i);
                String title = faker.educator().course();
                float credit = random.nextInt(4) + 1;
                CourseType type = random.nextBoolean() ? CourseType.THEORY : CourseType.LAB;

                Course course = new Course(code, title, credit, type);
                courseRepository.save(course);
            }
        };
    } 

    @Bean
    @Order(2)
    CommandLineRunner loadFakeDepartments(DepartmentRepository departmentRepository) {
        return args -> {
            Faker faker = new Faker();

            for(int i=0; i<10; i++) {
                String code = "DEPT" + (10+i);
                String name = faker.university().name();
                String abbreviation = faker.lorem().word();
                Department department = new Department(code, name, abbreviation);
                departments.add(department);
                departmentRepository.save(department);
            }
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner loadFakeCcsps(CcspRepository ccspRepository) {
        return args -> {
            Random random = new Random();
            for(int i=1; i<6; i++) {
                String name = i+"CSE(6M)";
                Department department = departments.get(random.nextInt(departments.size())); 
                int terms = 8;
                Ccsp ccsp = new Ccsp(name, department, terms);
                ccspRepository.save(ccsp);
            }
        };
    }
}
