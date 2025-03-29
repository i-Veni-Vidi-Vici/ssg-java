package com.ohgiraffers.hw2;


import java.util.Scanner;

public class StudentDTO {
    private Scanner sc = new Scanner(System.in);
    private int grade;
    private int classroom;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private StudentDTO[] students;

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

    public int getGrade() {
        return grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }
    public void information() {
        int count = 0;

        // 학생 정보 입력 받기
        char choice = 'y';
        while (choice == 'y' && count < 10) {
            System.out.println("학생 정보를 입력하세요.");
            System.out.print("이름: ");
            String getname = sc.next();
            System.out.print("국어 점수: ");
            int korscore = sc.nextInt();
            System.out.print("영어 점수: ");
            int engscore = sc.nextInt();
            System.out.print("수학 점수: ");
            int mathscore = sc.nextInt();

            students[count] = new StudentDTO(grade,classroom,name, kor, eng, math);
            count++;

            System.out.print("계속 입력하시겠습니까? (y/n): ");
            choice = sc.next().charAt(0); // 대소문자 구분 없이 'y' 입력 가능
        }

        // 점수 평균 구하기
        int totalKorean = 0, totalEnglish = 0, totalMath = 0;
        for (int i = 0; i < count; i++) {
            totalKorean += students[i].getKor();
            totalEnglish += students[i].getEng();
            totalMath += students[i].getMath();
        }
        double avgKorean = (double) totalKorean / count;
        double avgEnglish = (double) totalEnglish / count;
        double avgMath = (double) totalMath / count;

        // 학생 정보 출력
        System.out.println("\n학생 정보:");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }

        System.out.print("학년" + grade + "반" + classroom +  "이름: " + name + ", 국어: " + kor + ", 영어: " + eng + ", 수학: " + math);
        System.out.println("국어 평균: " + avgKorean);
        System.out.println("영어 평균: " + avgEnglish);
        System.out.println("수학 평균: " + avgMath);
    }
}
