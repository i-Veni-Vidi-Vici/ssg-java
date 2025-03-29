package com.sh._enum._02.basics;

public class Subject {
    private SubjectType subjectType;
    private String name;
    private int point;

    public Subject() {}

    public Subject(SubjectType subjectType, String name, int point) {
        this.subjectType = subjectType;
        this.name = name;
        this.point = point;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return point;
    }

    public void setScore(int score) {
        this.point = score;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectType=" + subjectType +
                ", name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
