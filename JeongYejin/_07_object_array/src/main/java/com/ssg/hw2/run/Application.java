package com.ssg.hw2.run;

import com.ssg.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDTO[] std = new StudentDTO[10];
        int index = 0;
        char ans;
        do {
            System.out.print("학년 : ");
            int grade = sc.nextInt();
            System.out.print("반 : ");
            int classroom = sc.nextInt();
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("국어점수 : ");
            int kor = sc.nextInt();
            System.out.print("영어점수 : ");
            int eng = sc.nextInt();
            System.out.print("수학점수 : ");
            int math = sc.nextInt();
            std[index] = new StudentDTO(grade, classroom, name, kor, eng, math);
            index++;
            System.out.print("계속 추가하시겠습니까? (y/n) : ");
            ans = sc.next().charAt(0);
            if (ans == 'n') break;
        } while (ans == 'y');

        for (int i = 0; i < index; i++) {
            double avg = (std[i].getKor() + std[i].getEng() + std[i].getMath()) / 3.0;
            System.out.print(std[i].information());
            System.out.printf(" 평균 : %.1f", avg);
            System.out.println();
        }
    }
}
