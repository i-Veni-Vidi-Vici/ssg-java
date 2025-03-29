package com.ssg.test.ohigiraffers.hw2.run;

import com.ssg.test.ohigiraffers.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        StudentDTO student[] = new StudentDTO[10];
        int grade = 0;
        int classroom = 0;
        String name = "";
        int kor = 0;
        int eng = 0;
        int math = 0;
        int cnt = 0;    // 카운트
        char answer = ' ';  // 추가할지 여부
        int sum = 0;    // 점수 합계

        // while문을 사용하여 학생들의 정보를 계속 입력 받고
        while(true) {
            System.out.println("> 학생 정보를 입력하세요");
            System.out.print("학년 : ");
            grade = sc.nextInt();
            System.out.print("반 : ");
            classroom = sc.nextInt();
            System.out.print("이름 : ");
            name = sc.next();
            System.out.print("국어점수 : ");
            kor = sc.nextInt();
            System.out.print("영어점수 : ");
            eng = sc.nextInt();
            System.out.print("수학점수 : ");
            math = sc.nextInt();

            student[cnt] = new StudentDTO(grade, classroom, name, kor, eng, math);

            // 한 명씩 추가 될때마다 카운트함
            cnt++;

            // 계속 추가할 것인지 물어보고, 대소문자 상관없이 'y'이면 계속 객체 추가
            // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
            System.out.print("> 계속 학생을 더 추가하겠습니까? (y/n) : ");
            answer = sc.next().charAt(0);
            if (answer=='y' || answer=='Y')
                System.out.println();
            else
                break;
        }

        System.out.println();
        System.out.println("==================================================");
        // 현재 기록된 학생들의 각각의 점수 평균을 구함
        for(int i=0; i<cnt; i++) {
            sum = student[i].getKor() + student[i].getEng() + student[i].getMath();

            // 학생들의 정보를 모두 출력 (평균 포함)
            System.out.printf(student[i].information() + ", 평균 : %.2f\n",  (sum / 3.0));

        }

    }
}
