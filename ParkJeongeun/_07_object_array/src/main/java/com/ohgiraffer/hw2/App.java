package com.ohgiraffer.hw2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] students = new StudentDTO[10];

        int index = 0;
        while (true){
            System.out.print("> 학년 입력 : ");
            int grade = sc.nextInt();
            System.out.print("> 반 입력 : ");
            int classroom = sc.nextInt();
            sc.nextLine();
            System.out.print("> 이름 입력 : ");
            String name = sc.nextLine();
            System.out.print("> 국어점수 입력 : ");
            int kor = sc.nextInt();
            System.out.print("> 영어점수 입력 : ");
            int eng = sc.nextInt();
            System.out.print("> 수학점수 입력 : ");
            int math = sc.nextInt();

            students[index] = new StudentDTO(grade, classroom, name, kor, eng, math);
            index++;

            System.out.print("> 학생정보를 추가하시겠습니까? (y/n) : ");
            char add = sc.next().charAt(0);
            if (add == 'y' || add == 'Y'){
                continue;
            } else {
                break;
            }
        }

        for (StudentDTO student : students) {
            if (student == null) {
                break;
            }
            int sum = student.getKor() + student.getEng() + student.getMath();
            System.out.println(student.information() + ", 평균: " + sum / 3);
        }
    }
}
