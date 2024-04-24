package com.ajay.spring.data.jpa.tutorial.repository;

import com.ajay.spring.data.jpa.tutorial.entity.Course;
import com.ajay.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBMS = Course.builder()
                .courseTitle("DBMS")
                .credit(5)
                .build();
        Course coursePython = Course.builder()
                .courseTitle("Python")
                .credit(8)
                .build();
        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(9)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("faraz")
                .lastName("khan")
                .courses(List.of(courseDBMS, coursePython, courseJava))
                .build();

        teacherRepository.save(teacher);

    }
}