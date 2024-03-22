package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        // while문을 사용하여 학생들의 정보를 계속 입력 받고
        // 한 명씩 추가 될 때마다 카운트함
        // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
        StudentDTO[] studentDTOS = new StudentDTO[10];
        Scanner sc = new Scanner(System.in);

        int index = 0;
        while (index < 10) {
            System.out.print("학년 :");

            studentDTOS[index] = new StudentDTO();
            studentDTOS[index].setGrade(sc.nextInt());

            System.out.print("반 :");
            studentDTOS[index].setClassroom(sc.nextInt());

            System.out.print("이름 :");
            studentDTOS[index].setName(sc.next());

            System.out.print("국어점수 :");
            studentDTOS[index].setKor(sc.nextInt());

            System.out.print("영어점수 :");
            studentDTOS[index].setEng(sc.nextInt());

            System.out.print("수학점수 :");
            studentDTOS[index++].setMath(sc.nextInt());

            System.out.println("계속?(y)");
            char number = sc.next().charAt(0);
            if (!(number == 'y' || number == 'Y')) {
                break;
            }
        }

        // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
        // 현재 기록된 학생들의 각각의 점수 평균을 구함
        // 학생들의 정보를 모두 출력 (평균 포함)

        int korSum = 0;
        int engSum = 0;
        int mathSum = 0;

        for (StudentDTO studentDTO : studentDTOS) {
            if (studentDTO == null) {
                break;
            }
            korSum += studentDTO.getKor();
            engSum += studentDTO.getEng();
            mathSum += studentDTO.getMath();
            System.out.println(studentDTO.information());
        }

        System.out.println("국어 평균 : " + (korSum / index)
                + "영어 평균 : " + (engSum / index)
                + "수학 평균 : " + (mathSum / index));


    }
}
