package com.ajay.spring.data.jpa.tutorial.repository;

import com.ajay.spring.data.jpa.tutorial.entity.Course;
import com.ajay.spring.data.jpa.tutorial.entity.Student;
import com.ajay.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("Courses: " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Diksha")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .courseTitle("Python5")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecords = PageRequest.of(0, 3);
        PageRequest SecondPageWithTwoRecords =  PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPageWithThreeRecords).getTotalElements();

        Long totalPages = (long) courseRepository.findAll((org.springframework.data.domain.Pageable) firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalPages: " + totalPages);

        System.out.println("Total elements: " + totalElements);
        System.out.println("Courses: " + courses);
    }

//    @Test
//    public void findAllSorting(){
//        PageRequest sortByTitle = PageRequest.of(0, 2, Sort.by("course_title"));
//        PageRequest sortByCredit = PageRequest.of(0, 2, Sort.by("credit").descending());
//        PageRequest sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
//
//        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
//
//        System.out.println("Courses: " + courses);
//    }

//    @Test
//    public void printByTitleContaining(){
//        PageRequest firstPageTenRecords = PageRequest.of(0, 10);
//
//        List<Course> courses = courseRepository.findbyTitleContaining("D", firstPageTenRecords).getContent();
//
//        System.out.println("Courses: " + courses);
//    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("shiv")
                .lastName("kumar")
                .build();

        Student student = Student.builder()
                .firstName("mike")
                .lastName("singh")
                .email("mike@gmail.com")
                .build();


        Course course = Course.builder()
                .courseTitle("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }
}