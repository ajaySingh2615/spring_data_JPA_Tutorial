package com.ajay.spring.data.jpa.tutorial.repository;

import com.ajay.spring.data.jpa.tutorial.entity.Course;
import com.ajay.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void courseMaterialRepositoryTest() {

        Course course = Course.builder()
                .courseTitle(".net")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("https://www.yahoo.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("courseMaterials: " + courseMaterials);

    }

}