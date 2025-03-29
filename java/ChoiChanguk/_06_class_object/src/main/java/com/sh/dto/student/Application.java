package com.sh.dto.student;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        StudentVO studentVO=new StudentVO();

        studentVO.setGrade(sc.nextInt());// 학년 셋
        studentVO.setClassroom(sc.nextInt());// 반 셋
        studentVO.setName(sc.next());// 이름 셋
        studentVO.setHeight(sc.nextDouble());// 키 셋
        studentVO.setGender(sc.next().charAt(0));// 성별 셋

        studentVO.printInformation();

    }
}
