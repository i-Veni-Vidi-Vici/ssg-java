package com.sh._enum._02.basics;

public class Subject {
    private SubjectType subjectType;
    private String marks;
    private int point;

    public Subject() {
    }

    public Subject(SubjectType subjectType, String marks, int point) {
        this.subjectType = subjectType;
        this.marks = marks;
        this.point = point;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectType='" + subjectType + '\'' +
                ", marks='" + marks + '\'' +
                ", point=" + point +
                '}';
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
