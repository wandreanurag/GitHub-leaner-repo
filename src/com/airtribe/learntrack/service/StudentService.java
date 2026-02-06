package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.ArrayList;

public class StudentService {
    private StudentRepository repo = new StudentRepository();

    public void addStudent(Student student) {
        repo.save(student);
    }

    public ArrayList<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudent(int id) throws EntityNotFoundException {
        Student student = repo.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found: " + id);
        }
        return student;
    }
}
