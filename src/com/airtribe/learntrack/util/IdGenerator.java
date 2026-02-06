package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int id = 1;
    public static int nextId() {
        return id++;
    }
}
