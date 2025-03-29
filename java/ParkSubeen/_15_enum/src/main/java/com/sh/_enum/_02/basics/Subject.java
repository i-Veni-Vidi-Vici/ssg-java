package com.sh._enum._02.basics;

public class Subject {
    private SubjectType type;
    private String desc;
    private int point;

    public Subject() {
    }

    public Subject(SubjectType subjectType, String ex, int score) {
        this.type = subjectType;
        this.desc = ex;
        this.point = score;
    }

    public SubjectType getSubjectType() {
        return type;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.type = subjectType;
    }

    public String getEx() {
        return desc;
    }

    public void setEx(String ex) {
        this.desc = ex;
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
                "subjectType=" + type +
                ", ex='" + desc + '\'' +
                ", score=" + point +
                '}';
    }
}
