package com.ssg.hw2.run;

import com.ssg.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentDTO[] std = new StudentDTO[10];
        Scanner sc = new Scanner(System.in);

        int count = 0;
        while (true) {
            System.out.print("학년 : ");
            int grade = sc.nextInt();

            System.out.print("반 : ");
            int classroom = sc.nextInt();

            System.out.print("이름 : ");
            String name = sc.next();

            System.out.print("국어 점수 : ");
            int kor = sc.nextInt();

            System.out.print("영어 점수 : ");
            int eng = sc.nextInt();

            System.out.print("수학 점수 : ");
            int math = sc.nextInt();

            std[count] = new StudentDTO(grade, classroom, name, kor, eng, math);
            count++;

            System.out.print("학생 정보를 추가하시나요? (Y / N): ");
            String choice = sc.next();

            if (choice.equals("n") || choice.equals("N")) {
                break;
            }
        }

        for (int i = 0; i < count; i++) {
            std[i].information();
            int sum = std[i].getKor() + std[i].getEng() + std[i].getMath();
            System.out.println(std[i].getName() + "의 평균 점수는 " + sum / 3 + "점 입니다.");

        }
    }
}