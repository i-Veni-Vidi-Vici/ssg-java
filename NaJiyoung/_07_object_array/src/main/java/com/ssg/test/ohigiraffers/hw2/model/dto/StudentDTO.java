package com.ssg.test.ohigiraffers.hw2.model.dto;

public class StudentDTO {
    private int grade;  // 학년
    private int classroom;  // 반
    private String name;    // 이름
    private int kor;    // 국어점수
    private int eng;    // 영어점수
    private int math;   // 수학점수

    public StudentDTO() {}

    public StudentDTO(int grade, int classroom, String name, int kor, int eng, int math) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String information() {
        return String.format("학년 : %d, 반 : %d, 이름 : %s, 국어점수 : %d, 영어점수 : %d, 수학점수 : %d", this.grade, this.classroom, this.name, this.kor, this.eng, this.math);
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
}
