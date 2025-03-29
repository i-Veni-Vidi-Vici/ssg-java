package com.ohgiraffers.hw2;

public class StudentDTO {
    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO() {
    }

    public StudentDTO(int grade, int classroom, String name, int kor, int eng, int math) {
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void information(){

    }
}
