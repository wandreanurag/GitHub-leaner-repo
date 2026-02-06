package com.airtribe.learntrack.entity;

public class Course {
    private int id;
    private String name;
    private boolean active;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }
    public String getDisplayCorseName() {
        return name ;
    }
}
