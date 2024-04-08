package com.sh._enum._02.basics;

public class Subject {
    private SubjectType type;
    private String desc;
    private int point;

    public Subject(SubjectType type, String desc, int point) {
        this.type = type;
        this.desc = desc;
        this.point = point;
    }

    public Subject() {
    }

}
