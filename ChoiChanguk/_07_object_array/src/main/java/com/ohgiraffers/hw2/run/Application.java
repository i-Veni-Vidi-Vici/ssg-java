package com.ohgiraffers.hw2.run;

import com.ohgiraffers.hw2.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int cnt=0;

        StudentDTO[] studentDTO=new StudentDTO[10];
        while (true)
        {
            studentDTO[cnt]=new StudentDTO(sc.nextInt(),sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            cnt++;
            System.out.println("계속 추가 하십니까??");
            if (sc.next().charAt(0) != 'Y' || sc.next().charAt(0) != 'y') {
                break;
            }
        }
        System.out.printf("학년 반 이름 국어점수 영어점수 수학점수");
        for(int i=0;i<cnt;i++)
        {
            System.out.println(studentDTO[i].information());
        }
    }
}
