package com.ssg.hw2.run;

import com.ssg.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        StudentDTO[] studentArrs = new StudentDTO[10];

        // while문을 사용하여 학생들의 정보를 계속 입력 받고
        // 한 명씩 추가 될 때마다 카운트함
        // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
        // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
        System.out.println("학생정보를 입력하겠습니다. ");
        char yn;
        int count = 0;

        while (count < studentArrs.length) {

            System.out.println("학년 입력 : ");
            int grade = sc.nextInt();
            System.out.println("반 입력 : ");
            int classroom = sc.nextInt();
            System.out.println("이름 입력 : ");
            String name = sc.next();
            System.out.println("국어점수 입력 : ");
            int kor = sc.nextInt();
            System.out.println("영어점수 입력 : ");
            int eng = sc.nextInt();
            System.out.println("수학점수 입력 : ");
            int math = sc.nextInt();

            studentArrs[count] = new StudentDTO(grade, classroom, name, kor, eng, math);
            count++;

            if (count == studentArrs.length) {
                System.out.println("더이상 추가하실 수 없습니다...");
                break;
            }


            System.out.println("학생정보를 추가하시겠습니까? (y/n) : ");
            yn = sc.next().charAt(0);
            if (yn == 'y' || yn == 'Y') {
                System.out.println("학생정보를 추가합니다...");
            } else {
                System.out.println("> 프로그램을 종료합니다...");
                break;
            }
        }

        // 현재 기록된 학생들의 각각의 점수 평균을 구함
        // 학생들의 정보를 모두 출력 (평균 포함)
        int sum = 0;
        int avarage = 0;
        for (StudentDTO s : studentArrs) {
            if (s == null) {
                break;
            }

            sum = s.getKor() + s.getEng() + s.getMath();
            avarage = sum / 3;
            System.out.println(s.information() + "평균점수 : " + avarage + "\n");
        }

    }
}
