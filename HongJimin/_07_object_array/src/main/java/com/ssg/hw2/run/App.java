package com.ssg.hw2.run;

import com.ssg.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentDTO[] studentDTOs = new StudentDTO[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < studentDTOs.length; i++) {
            studentDTOs[i] = new StudentDTO();
        }

        String choice = "Y";
        int i = 0;

         while (choice.charAt(0) == 'Y' || choice.charAt(0) =='y') {
            System.out.print("학년 : ");
            int grade = sc.nextInt();
            studentDTOs[i].setGrade(grade);

            System.out.print("반 : ");
            int classroom = sc.nextInt();
            studentDTOs[i].setClassroom(classroom);

            System.out.print("이름 : ");
            String name = sc.next();
            studentDTOs[i].setName(name);

            System.out.print("국어 점수 : ");
            int kor = sc.nextInt();
            studentDTOs[i].setKor(kor);

            System.out.print("영어 점수 : ");
            int eng = sc.nextInt();
            studentDTOs[i].setEng(eng);

            System.out.print("수학 점수 : ");
            int math = sc.nextInt();
            studentDTOs[i].setMath(math);

            System.out.print("학생 정보를 추가하시나요? : ");
            choice = sc.next();
            i++;
        }


        for (StudentDTO studentDTO : studentDTOs) {
            studentDTO.information();
        }

        int stdScores = 0;
        int[] scores = new int[3];
        for (int j = 0; j < studentDTOs.length; j++) {
            scores[j] = studentDTOs[j].getKor() + studentDTOs[j].getEng() + studentDTOs[j].getMath();
            stdScores += scores[j];
            System.out.println(studentDTOs[j].getName() + "의 평균은 " + (scores[j] / 3) + "점 입니다.");
        }
        System.out.println("전체 평균은 " + stdScores / 3 + "점 입니다.");

    }

// 현재 기록된 학생들의 각각의 점수 평균을 구함
// 학생들의 정보를 모두 출력 (평균 포함)

}

