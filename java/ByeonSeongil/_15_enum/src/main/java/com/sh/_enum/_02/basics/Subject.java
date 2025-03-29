package com.sh._enum._02.basics;

public class Subject {
    private SubjectType subjectType;
    private String description;
    private int score;

    public Subject(SubjectType subjectType, String description, int score) {
        this.subjectType = subjectType;
        this.description = description;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectType=" + subjectType +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }
}
