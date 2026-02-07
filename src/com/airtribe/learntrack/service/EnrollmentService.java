package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository repo = new EnrollmentRepository();

    public void enrollStudent(Enrollment e) {
        repo.save(e);
    }

    public List<Enrollment> getEnrollmentsForStudent(int studentId) {
        return repo.findByStudentId(studentId);
    }
}
