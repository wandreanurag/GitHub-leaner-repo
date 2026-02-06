package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;

import java.util.ArrayList;

public class CourseService {
    private CourseRepository repo = new CourseRepository();

    public void addCourse(Course c) {
        repo.save(c);
    }
    public ArrayList<Course> getAllCorse() {
        System.out.println("View List Corses");
        return repo.findAll();
    }

    public Course getCourse(int id) throws EntityNotFoundException {
        Course c = repo.findById(id);
        if (c == null) {
            throw new EntityNotFoundException("Course not found: " + id);
        }
        return c;
    }

    }


