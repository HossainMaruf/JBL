package com.example.jbl.config;

import java.util.Random;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.javafaker.Faker;
import com.example.jbl.model.Course;
import com.example.jbl.model.CourseType;
import com.example.jbl.repository.CourseRepository;

@Configuration
public class DataLoader {
   @Bean
   CommandLineRunner loadFakeCourses(CourseRepository courseRepository) {
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
   } 
}
