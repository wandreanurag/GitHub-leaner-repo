package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;

public class CourseRepository {


    private ArrayList<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Course> findAll() {
        return courses;
    }
}