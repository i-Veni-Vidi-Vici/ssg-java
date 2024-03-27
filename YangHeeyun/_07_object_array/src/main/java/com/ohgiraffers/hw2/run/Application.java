package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        StudentDTO[] studentDTO = new StudentDTO[10];

        // while문을 사용하여 학생들의 정보를 계속 입력 받고
        int cnt=0;
        char yesNo = 'y';
        double avg;
//        int sum = 0;

        while(yesNo == 'y'){
            System.out.print("학년 입력 > ");
            int grade = sc.nextInt();
            System.out.print("반 입력 > ");
            int classroom = sc.nextInt();
            System.out.print("이름 입력 > ");
            String name = sc.next();
            System.out.print("국어점수 입력 > ");
            int kor = sc.nextInt();
            System.out.print("영어점수 입력 > ");
            int eng = sc.nextInt();
            System.out.print("수학점수 입력 > ");
            int math = sc.nextInt();

            // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
            studentDTO[cnt] = new StudentDTO(grade,classroom,name,kor,eng,math);
            // 한 명씩 추가 될 때마다 카운트함
            cnt++;
            // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
            System.out.print("계속 추가하시겠습니까?(y/n)");
            yesNo = sc.next().toLowerCase().charAt(0);
            if(yesNo == 'n')
                break;
        }

        // 현재 기록된 학생들의 각각의 점수 평균을 구함
        // 학생들의 정보를 모두 출력 (평균 포함)
//        for (StudentDTO dto : studentDTO) {
//            if(dto == null){
//                break;
//            }
//            sum = dto.getKor() + dto.getEng() + dto.getMath();
//            System.out.println(dto.information() + ", 평균= " + sum/3);
//        }

        for(int i=0;i< studentDTO.length;i++){
            if(studentDTO[i] == null){
                break;
            }
            avg = (double)(studentDTO[i].getKor() + studentDTO[i].getEng() + studentDTO[i].getMath())/3;
            System.out.printf("%s, 평균 = %.1f",studentDTO[i].information(),avg);
        }
    }
}
