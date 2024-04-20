package com.ajay.spring.data.jpa.tutorial.repository;

import com.ajay.spring.data.jpa.tutorial.entity.Guardian;
import com.ajay.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest
public class StudentRepositoryTest implements StudentRepository {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("ajay@gmail.com")
                .firstName("ajay")
                .lastName("singh")
                //.guardianName("parent")
                //.guardianEmail("parent@gmail.com")
                //.guardianMobile("999998767")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .name("guardian")
                .mobile("987888889")
                .build();

        Student student = Student.builder()
                .firstName("shivam")
                .email("shivam@gmail.com")
                .lastName("singh")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList: " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("shivam");

        System.out.println("students: " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("s");

        System.out.println("students: " + students);
    }

    @Test
    public void printStudentNameBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("parent");
        System.out.println("students: " + students);
    }



    @Override
    public <S extends Student> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Student> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public List<Student> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Student entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Student> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Student> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Student> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Student getOne(Long aLong) {
        return null;
    }

    @Override
    public Student getById(Long aLong) {
        return null;
    }

    @Override
    public Student getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Student> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Student> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Student> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Student> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Student, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Student> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return List.of();
    }

    @Override
    public List<Student> findByFirstNameContaining(String name) {
        return List.of();
    }

    @Override
    public List<Student> findByLastNameNotNull() {
        return List.of();
    }

    @Override
    public List<Student> findByGuardianName(String guardianName) {
        return List.of();
    }
}
