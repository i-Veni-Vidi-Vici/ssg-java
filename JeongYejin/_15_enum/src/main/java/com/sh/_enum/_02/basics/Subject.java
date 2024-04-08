package com.sh._enum._02.basics;

public class Subject {
    private SubjectType subjectType;
    private String explain;
    private int assigned;

    public Subject(SubjectType subjectType, String explain, int assigned) {
        this.subjectType = subjectType;
        this.explain = explain;
        this.assigned = assigned;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getAssigned() {
        return assigned;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectType=" + subjectType +
                ", explain='" + explain + '\'' +
                ", assigned=" + assigned +
                '}';
    }
}
