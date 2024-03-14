package com.sh.condition._if;

import java.util.Scanner;

public class IfElseIf {
    Scanner sc = new Scanner(System.in);
    public void test() {
        System.out.println("입력");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("if");
        } else if (choice == 2) {
            System.out.println("else if");
        } else {
            System.out.println("else");
        }
    }
    public void test2() {
        System.out.println("점수 입력(0 ~ 100) : ");
        int score = sc.nextInt();
        char grade;

        if (score >= 90 && score <= 100) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else if (score >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        System.out.println(grade);
    }
}
