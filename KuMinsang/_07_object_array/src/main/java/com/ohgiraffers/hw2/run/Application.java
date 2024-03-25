package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;

import java.util.Scanner;

/**
 * 최대 10명의 학생 정보를 기록할 수 있게 객체 배열을 할당하고
 * 반복문을 사용하여 키보드로 학생 정보를 입력 받도록 구현
 * 3명의 학생 정보를 입력 받아, 각 객체에 저장
 * 현재 기록된 학생들의 정보와 각 학생의 평균 점수를 출력
 */
public class Application {
    public static void main(String[] args) {
        int i=0;
        int cnt=0;
        boolean flag =true;
        double avgeng=0;
        double avgkor=0;
        double avgmath=0;

       Scanner sc = new Scanner(System.in);
        // 최대 10명의 학생 정보를 기록할 수 있게 배열을 할당한다.
        StudentDTO[] student = new StudentDTO[10];
        // while문을 사용하여 학생들의 정보를 계속 입력 받고

        while(flag) {
            System.out.print("학년 , 반, 이름, 국어점수, 영어점수, 수학점수 ");
            student[i] = new StudentDTO(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            cnt++; // 한 명씩 추가 될 때마다 카운트함
            // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
            System.out.println("계속 추가 하시겠습니까?");
            switch (sc.next()){
                case "y" :
                    i++;
                    break;
                case "Y" :
                    i++;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        // 3명 정도의 학생 정보를 입력 받아 각 객체에 저장함
        // 현재 기록된 학생들의 각각의 점수 평균을 구함
        avgeng=0;
        avgkor=0;
        avgmath=0;
        for(int k=0; k< cnt; k++){
            avgeng += student[k].getEng();
            avgkor += student[k].getKor();
            avgmath +=student[k].getMath();
        }
        avgeng= avgeng/cnt;
        avgkor = avgkor/cnt;
        avgmath = avgmath/cnt;
        // 학생들의 정보를 모두 출력 (평균 포함)
        for(int k=0; k<cnt; k++){
            System.out.printf(student[k].information());
        }
        System.out.printf("[평균 성적] 국어 : %.1f 영어 : %.1f 수학 : %.1f ", avgeng, avgkor, avgmath);




    }
}
