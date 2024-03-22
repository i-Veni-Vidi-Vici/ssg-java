package com.ohgiraffers.hw2.model.dto;

import java.util.Scanner;

public class StudentDTO
{
    private  Scanner scanner;
    private int grade;
    private int classromm;
    private String name;
    private int kor;
    private int eng;
    private int math;

    public StudentDTO() {
    }

    public StudentDTO(int grade, int classromm, String name, int kor, int eng, int math) {
        this.grade = grade;
        this.classromm = classromm;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    public void input() {
        Scanner sc = new Scanner(System.in);
        this.grade = sc.nextInt();
        this.classromm = sc.nextInt();
        this.name = sc.next();
        this.kor = sc.nextInt();
        this.eng = sc.nextInt();
        this.math = sc.nextInt();
    }

    public String information()
    {
        String menu = """
         학년    반    이름    국어점수     영어점수   수학점수    평균
         """;
        return menu;
    }

    public int getAverage()
    {
        return (kor + eng + math) / 3;
    }


    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassromm() {
        return classromm;
    }

    public void setClassromm(int classromm) {
        this.classromm = classromm;
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


}
