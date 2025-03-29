package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        char check;
        double avg;
        int cnt=0;

        StudentDTO[] studentDTO=new StudentDTO[10];
        while (true)
        {
            System.out.printf("학년 반 이름 국어점수 영어점수 수학점수\n");
            studentDTO[cnt]=new StudentDTO(sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            cnt++;
            System.out.println("계속 추가 하십니까?? Y or y");
            check=sc.next().charAt(0);
            if (check != 'Y' && check != 'y') {
                break;
            }
        }
        System.out.printf("학년 반 이름 국어점수 영어점수 수학점수 평균\n");
        for(int i=0;i<cnt;i++)
        {
            avg=studentDTO[i].getKor()+studentDTO[i].getEng()+studentDTO[i].getMath();
            System.out.println(studentDTO[i].information()+"    "+(int)avg/3);
        }
    }
}
