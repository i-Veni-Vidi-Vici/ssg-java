package com.sh._enum._02.basics;

public class Subject {
    private SubjectType subjectType;
    private String desc;
    private int point; // 배점

    public Subject() {
    }

    public Subject(SubjectType subjectType, String desc, int point) {
        this.subjectType = subjectType;
        this.desc = desc;
        this.point = point;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "type=" + subjectType +
                ", desc=" + desc + '\'' +
                ", point=" + point +
                '}';
    }
}
