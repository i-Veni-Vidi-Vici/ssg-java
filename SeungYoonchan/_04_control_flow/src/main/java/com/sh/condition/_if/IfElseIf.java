package com.sh.condition._if;

import java.util.Scanner;

public class IfElseIf {
    public void test() {
        Scanner sc = new Scanner(System.in);

        System.out.println("풍덩");
        System.out.println("1. 금도끼 2. 은도끼 3. 쇠도끼");

        int choice = sc.nextInt();
    }

    public void test2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("> 점수을 입력하세요. : ");
        int score = sc.nextInt();
        String grade;

        if(score>=95){
            grade = "A+";
        }
        else if(score <95 && score>=90){
            grade = "A";
        }
        else if(score <90 && score>=85){
            grade = "B+";
        }
        else if(score <85 && score>=80){
            grade = "B";
        }
        else if(score <80 && score>=75){
            grade = "C+";
        }
        else if(score <75 && score>=70){
            grade = "C";
        }
        else if(score <70 && score>=65){
            grade = "D+";
        }
        else if(score <65 && score>=60){
            grade = "D";
        }
        else{
            grade = "F";
        }

        System.out.println("점수는 : " + score + " 입니다");
        System.out.println("학점은 : " + grade + " 입니다");
    }
}
