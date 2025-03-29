package com.sh._enum._02.basics;

public class Subject {
    private SubjectType type;
    private String desc;
    private int point;

    @Override
    public String toString() {
        return "Subject{" +
                "type=" + type +
                ", desc='" + desc + '\'' +
                ", point=" + point +
                '}';
    }

    public SubjectType getType() {
        return type;
    }

    public void setType(SubjectType type) {
        this.type = type;
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

    public Subject(){}
    public Subject(SubjectType type, String desc, int point) {
        this.type = type;
        this.desc = desc;
        this.point = point;
    }
}
