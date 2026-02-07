package com.airtribe.learntrack.entity;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private String status; // ACTIVE, COMPLETED, CANCELLED

    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = "ACTIVE";
    }

    public int getStudentId() {
        return studentId;
    }
    public int getCourseId() {
        return courseId;
    }
    public String getStatus() {
        return status;
    }

    public void complete() {
        this.status = "COMPLETED";
    }
    public void cancel() {
        this.status = "CANCELLED";
    }

}
