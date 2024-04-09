package com.sh._enum._02.basics;

public class Subject {
    private SubjectType subjectType;
    private String info;
    private int score;

    public Subject() {
    }

    public Subject(SubjectType subjectType, String info, int score) {
        this.subjectType = subjectType;
        this.info = info;
        this.score = score;
    }

    @Override
    public String toString() {
        return
                "subjectType=" + subjectType +
                ", info='" + info + '\'' +
                ", score=" + score;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
