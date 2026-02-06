package com.airtribe.learntrack.entity;

public class Student  extends Person{
    private String batch;
    private boolean active;
    public Student(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }
    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }
}
