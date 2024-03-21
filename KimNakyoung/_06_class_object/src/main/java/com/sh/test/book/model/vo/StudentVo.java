package com.sh.test.book.model.vo;

import java.util.Scanner;

public class StudentVo {
    private int grade ;
    private int classroom ;
    private String name  ;
    private double height;
    private char gender ;




    //기본생성자
    public StudentVo(){
        this.grade = grade;
        this.classroom = classroom;
        this.name = name;
        this.height = height;
        this.gender = gender;

        Scanner sc = new Scanner(System.in);
        System.out.print("> 학년을 입력해주세요 : ");
        grade = sc.nextInt();
        System.out.print("> 반을 입력해주세요 : ");
        classroom = sc.nextInt();
        System.out.print("> 이름을 입력해주세요 : ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("> 키을 입력해주세요 : ");
        height = sc.nextDouble();
        System.out.print("> 성별을 입력해주세요 : ");
//        sc.nextLine();
        gender = sc.next().charAt(0);


    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public int getGrade(){
        return this.grade;
    }

    public void setClassroom(int classroom){
        this.classroom = classroom;
    }

    public  int getClassroom(){
        return classroom;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void  setGender(char gender){
        this.gender = gender;
    }
    public char getGender(){
        return gender;
    }

    public void printlnformation(){
        // new 할 때 마다 힙영역에 새롭게 만들어짐
        System.out.println("학년 : " + this.getGrade());
        System.out.println("반 : " + this.getClassroom());
        System.out.println("이름 : " +this.getName());
        System.out.println("키 : " + this.getHeight());
        System.out.println("성별 : " + this.getGender());
        System.out.println();
    }
    
}
